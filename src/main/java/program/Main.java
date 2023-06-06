package program;
import enums.Question_Type;
import models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HiberContext;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //testRole();
        //System.out.println("--------------");
        //testQuestions();
        //System.out.println("--------------");
        //addUserAndRoles();
        //System.out.println("--------------");
        //addCategory("Headphones", "5.jpg");
        //System.out.println("--------------");
        //addProduct();
        //System.out.println("--------------");
        //addBasket();
        //System.out.println("--------------");
        //addFilterNames();
        //System.out.println("--------------");
        //addFilterValues();
        //System.out.println("--------------");
        //addFilters();
        //System.out.println("--------------");
        //addFilterNameGroups();
        //System.out.println("--------------");
        //addOrderStatuses();
        //addOrder();
        //addOrderItem();
        //System.out.println("--------------");
        try(Session context = HiberContext.getSessionFactory().openSession()) {

        }
    }
    private static void addOrderItem() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Order order = new Order();
            order.setId(5);
            Product prod = new Product();
            prod.setId(5);
            OrderItem oi = new OrderItem(false, new Date(), 900, 1);
            oi.setOrder(order);
            oi.setProduct(prod);
            context.save(oi);
        }
    }
    private static void addOrder() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            OrderStatus os = new OrderStatus();
            os.setId(5);
            User user = new User();
            user.setId(5);
            Order order = new Order(false, new Date());
            order.setOrderStatus(os);
            order.setUser(user);
            context.save(order);
        }
    }
    private static void addOrderStatuses() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            OrderStatus os = new OrderStatus(false, new Date(), "delivered");
            context.save(os);
        }
    }
    private static void addFilterNameGroups() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            FilterNames fn = new FilterNames();
            fn.setName("GPU NVIDIA GeForce 1650Ti");
            context.save(fn);

            FilterValues fv = new FilterValues(false, new Date(), "Test filter value 14");
            context.save(fv);

            FilterNameGroups fng = new FilterNameGroups();
            fng.setFn(fn);
            fng.setFv(fv);
            context.save(fng);
            tx.commit();
        }
    }
    private static void addFilters() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            FilterNames fn = new FilterNames();
            fn.setName("Wifi Adapter");
            context.save(fn);

            FilterValues fv = new FilterValues(false, new Date(), "Test filter value 9");
            context.save(fv);

            var cat = context.get(Category.class, 3);
            Product prod = new Product(new Date(), false, "Xiaomi TV", "Good TV", cat);
            context.save(prod);

            Filters filters = new Filters();
            filters.setFn(fn);
            filters.setFv(fv);
            filters.setProduct(prod);
            context.save(filters);
            tx.commit();
        }
    }
    private static void addFilterValues() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            FilterValues fv = new FilterValues(false, new Date(), "Test filter value 5");
            context.save(fv);
        }
    }
    private static void addFilterNames() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            FilterNames fn = new FilterNames(false, new Date(), "Screen");
            context.save(fn);
        }
    }
    private static void addBasket() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            User user = new User("Geralt", "OfRivia", "witcher@gmail.com", "+35131325",
                    "qwerty2");
            context.save(user);

            var cat = context.get(Category.class, 3);
            Product prod = new Product(new Date(), false, "Samsung Smart TV", "Good TV",
                    cat);
            context.save(prod);

            Basket basket = new Basket();
            basket.setUser(user);
            basket.setProduct(prod);
            context.save(basket);
            tx.commit();
        }
    }
    private static void addProduct() {
        //створюємо контекст для роботи з БД
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            var cat = context.get(Category.class, 5);
            //створюємо продукт
            Product p = new Product(new Date(), false, "Xiaomi Mi 11 Lite", "The best phone", cat);
            //зберігаємо продукт
            context.save(p);
            ProductImage pi1 = new ProductImage(new Date(), false, "1.jpg", 1, p);
            ProductImage pi2 = new ProductImage(new Date(), false, "2.jpg", 2, p);
            context.save(pi1);
            context.save(pi2);
            tx.commit();
        }
    }
    private static void addCategory(String name, String image) {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Category c = new Category(name, image, new Date(), false);
            context.save(c);
        }
    }
    private static void addUserAndRoles() {
        try(Session context = HiberContext.getSessionFactory().openSession()) {
            Transaction tx = context.beginTransaction();
            Role role = new Role();
            //створюємо нову роль
            role.setName("User");
            context.save(role);

            //ствоюємо новго користувача
            User user = new User("Clemenntine", "Voight", "clem.v@gmail.com",
                    "+8565496558", "password");
            context.save(user);
            UserRole ur = new UserRole();
            //зв'язуємо користувача з роллю
            ur.setRole(role);
            ur.setUser(user);
            context.save(ur);
            tx.commit();
        }
    }
    private static void testQuestions() {
        try {
            //виводимо питання і варіанти відповіді на екран
            addQuestionItem(1, "1945", false);
            addQuestionItem(1, "1986", true);
            addQuestionItem(1, "1991", false);
        }
        catch (Exception ex) {
            System.out.println("Error :c" + ex.getMessage());
        }
    }

    private static void addQuestion(String text, Question_Type type) throws SQLException {
        //створюємо контекст для роботи з БД
        Session context = HiberContext.getSessionFactory().openSession();
        Transaction tx = context.beginTransaction();
        //створюємо питання
        Question q = new Question();
        q.setText(text);
        //задаємо тип питання
        q.setQuestion_type(type);
        context.save(q);
        //добавляємо і закриваємо звязок з базою
        tx.commit();
        context.close();
    }

    private static void addQuestionItem(int questionId, String text,
                                        boolean isTrue ) throws SQLException {
        Session session = HiberContext.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Question question = new Question();
        question.setId(questionId);
        QuestionItems qi = new QuestionItems(question, text, isTrue);
        session.save(qi);
        tx.commit();
        session.close();
    }
    private static void testRole() {
        //створюємо сканер, щоб зчитувати введену інформацію
        Scanner in = new Scanner(System.in);
        System.out.println("Hello Java!");

//        System.out.println("Enter role`s name");
//        Role role = new Role();
//        //вводимо назву нової ролі
//        String name = in.nextLine();
//        //зберігаємо назву нової ролі
//        role.setName(name);
          //виводимо назву нової ролі
//        System.out.println(role);

        //створюємо контекст для роботи з БД
        Session context = HiberContext.getSessionFactory().openSession();
//        context.save(role);
        //виводимо всі ролі які маємо в базі
        Query query = context.createQuery("FROM Role");
        List<Role> roles = query.list();
        for (Role role: roles)
            System.out.println(role);
        //закриваємо з'єднання з базою
        context.close();

//        System.out.println("Role id = " + role.getId());
    }
}
