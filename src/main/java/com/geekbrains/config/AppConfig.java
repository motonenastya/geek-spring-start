package com.geekbrains.config;

//import com.geekbrains.models.Order;
import com.geekbrains.models.Buyer;
import com.geekbrains.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.persistence.criteria.Order;

@EnableWebMvc
//включает поддержку аннотации MVC-компонентов (например, @Controller);
@Configuration
@ComponentScan("com.geekbrains")
//в данном случае указывает на пакет, в котором хранятся класс-контроллеры;
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"
        );
    }
//    — добавляет обработчик ресурсов. Метод принимает объект класса
//ResourceHandlerRegistry и добавляет шаблон пути и локацию. Другими словами, на все
//запросы /resources/** будет вызываться не контроллер, созданный разработчиком, а
//возвращаться указанный в запросе файл (например, .css или .js).

    @Bean("session")
    public Session session(){
        SessionFactory factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new
                SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new
                ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }
//thymeleafViewResolver() — создает и настраивает бин, который является тем самым
//ViewResolver. Вспомним: контроллер возвращает только строку имени html-страницы, а
//DispatcherServlet обращается к данному бину, который формирует полный путь к
//представлению, прибавляя к его имени параметры, указанные в методах setPrefix и setSuffix
}
