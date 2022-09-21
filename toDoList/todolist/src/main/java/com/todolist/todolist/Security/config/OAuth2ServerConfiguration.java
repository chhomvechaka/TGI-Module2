package com.todolist.todolist.Security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
@Configuration
public class OAuth2ServerConfiguration {
   @Configuration
   @EnableResourceServer
   protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
    private final JwtAccessTokenConverter jwtAccessTokenConverter;
    public ResourceServerConfiguration(JwtAccessTokenConverter jwtAccessTokenConverter){
      this.jwtAccessTokenConverter=jwtAccessTokenConverter;
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resource){
      resource.tokenStore(new JwtTokenStore(jwtAccessTokenConverter));
    }
    @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .anyRequest()
                    .authenticated();
        }
   }
   @Configuration
   @EnableAuthorizationServer
   protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

       private final JwtAccessTokenConverter jwtAccessTokenConverter;

       private final BCryptPasswordEncoder passwordEncoder;

       private final AuthenticationManager authenticationManager;

       private final UserDetailsService userDetailsService;

       public AuthorizationServerConfiguration(JwtAccessTokenConverter jwtAccessTokenConverter,
               BCryptPasswordEncoder passwordEncoder,
               AuthenticationManager authenticationManager,
               UserDetailsService userDetailsService) {
           this.jwtAccessTokenConverter = jwtAccessTokenConverter;
           this.passwordEncoder = passwordEncoder;
           this.authenticationManager = authenticationManager;
           this.userDetailsService = userDetailsService;
       }

       @Override
       public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
           endpoints
                   .tokenStore(new JwtTokenStore(jwtAccessTokenConverter))
                   .authenticationManager(authenticationManager)
                   .accessTokenConverter(jwtAccessTokenConverter)
                   .userDetailsService(userDetailsService);
       }

       @Override
       public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
           clients
                   .inMemory()
                   .withClient("group4")
                   .secret(passwordEncoder.encode("group4"))
                   .authorizedGrantTypes("password", "refresh_token")
                   .scopes("read", "write")
                   .accessTokenValiditySeconds(3600);
       }

   }
}
