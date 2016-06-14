# spring-social-runkeeper
Connect your Spring application with Runkeeper Health Graph API.

## Getting Started
Add the dependency to your pom.xml:
```xml
<dependency>
  <groupId>com.wetjens.springframework</groupId>
  <artifactId>spring-social-runkeeper</artifactId>
  <version>1.0.0</version>
</dependency>
```

Runkeeper offers an API with OAuth 2.0 support.

Add Runkeeper support to your Spring Social configuration:
```java
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        // ...

        connectionFactoryConfigurer.addConnectionFactory(new RunkeeperConnectionFactory("clientId", "clientSecret"));
    }
}
```
You must configure the OAuth 2.0 client ID and client secret provided by Runkeeper.

## Connect
For connecting users to Runkeeper, follow the standard Spring Social procedure:
http://docs.spring.io/spring-social/docs/1.0.3.RELEASE/reference/html/connecting.html.


## Sign in
For signing in users with Runkeeper, follow the standard Spring Social procedure:
http://docs.spring.io/spring-social/docs/1.0.3.RELEASE/reference/html/signin.html.
