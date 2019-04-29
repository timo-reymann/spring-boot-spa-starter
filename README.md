spring-boot-spa-starter
===

## What is this?
Simple, yet powerful starter for powering your single page application with an servlet backend, including an configuration endpoint.

It adds 

- an configuration endpoint
- index.html rewriting for all non existing sources

## Requirements
Spring Boot 2.1+

### How to use?
Simply add it to your dependencies
```xml
<dependency>
    <groupId>com.github.timo-reymann</groupId>
    <artifactId>spring-boot-spa-starter</artifactId>
    <version>1.1.0</version>
</dependency>
```

The configuration is pretty simple

```yaml
frontend:
  # map for your configuration, keyed by string, the value can be anything jackson can serialize
  configuration:
    userApi: 'https://userapi.gateway.company.com'
    stockApi: 'https://stockapi.gateway.company.com'
    useNewStuff: true
  
  # optional, specify the endpoint if you want to override the default
  configuration-endpoint: /configuration 
  
  # Cache period for the assets
  cache-period: 0
```

The configuration options are available under the configured endpoint as a json object, that's it.

If you want to adjust the location for static files etc. simply use the config props available uner `spring.resources.*`.