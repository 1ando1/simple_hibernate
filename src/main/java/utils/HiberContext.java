package utils;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HiberContext {
    private static SessionFactory sessionFactory;
    private HiberContext() {}
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            //Читаємо конфігурацію
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Role.class);
            configuration.addAnnotatedClass(Question.class);
            configuration.addAnnotatedClass(QuestionItems.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(UserRole.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(Product.class);
            configuration.addAnnotatedClass(ProductImage.class);
            configuration.addAnnotatedClass(Basket.class);
            configuration.addAnnotatedClass(FilterNames.class);
            configuration.addAnnotatedClass(FilterValues.class);
            configuration.addAnnotatedClass(Filters.class);
            configuration.addAnnotatedClass(FilterNameGroups.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(OrderItem.class);
            configuration.addAnnotatedClass(OrderStatus.class);
            //Реєструємо сервіс на основі нашого конфіга
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            //Створюємо контекст до ДБ
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
