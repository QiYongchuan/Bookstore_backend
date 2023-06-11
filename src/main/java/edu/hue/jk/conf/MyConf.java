package edu.hue.jk.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 将逻辑地址与物理地址进行匹配，当用户输入逻辑地址时，自动匹配到服务器的物理地址
@Configurable
public class MyConf implements WebMvcConfigurer {
  @Value("${bookstore.upload-loadtions}")
    private String uploadLocation;

  @Value("${bookstore.url-path}")
    private String urlPath;

  public void addResourceHandlers(ResourceHandlerRegistry registry){
      registry.addResourceHandler(urlPath).addResourceLocations("file:/"+uploadLocation);
  }
// 实现逻辑地址和物理地址的映射
}
