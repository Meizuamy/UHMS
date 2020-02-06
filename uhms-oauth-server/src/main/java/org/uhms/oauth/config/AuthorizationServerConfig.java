package org.uhms.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .scopes("scopes")
                .secret("secret")
                .authorizedGrantTypes("password","authorization_code","refresh_token")
            .and()
                .withClient("webapp")
                .scopes("scopes")
                .authorizedGrantTypes("implicit")
                .redirectUris("https://www.baidu.com");
    }
}
