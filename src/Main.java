import dao.DsVolatile.GroupDao;
import dao.DsVolatile.StudentDao;
import dao.IDao;
import lombok.var;
import metier.ClassNotFoundException;
import metier.GroupeMetier;
import metier.IGroupeMetier;
import metier.IStudentMetier;
import metier.StudentMetier;
import models.Groupe;
import models.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.GroupeController;
import presentation.IGroupeController;
import presentation.IStudentController;
import presentation.StudentController;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    static IStudentController sController;
    static IGroupeController gController;
    static Scanner clavier = new Scanner(System.in);

     static void test1() throws ClassNotFoundException  {
         IDao<Student , String> sDao = new StudentDao();
         IDao<Groupe , Integer> gDao = new GroupDao();

         IStudentMetier sMetier = new StudentMetier();
         IGroupeMetier gMetier = new GroupeMetier();


         sController = new StudentController();
         gController = new GroupeController();

         ((StudentMetier)sMetier).setDao(sDao);
         ((GroupeMetier)gMetier).setDao(gDao);


         ((StudentController)sController).setMetier(sMetier);
         ((GroupeController)gController).setMetier(gMetier);
         gController.afficherNoteGenerale(1);
            sController.afficherNoteGeneral("A01");

     }

    public static void test2() throws Exception {

        gController                      = null;
        sController                      = null;
        IStudentMetier sservice           = null;
        IGroupeMetier gservice           = null;
        IDao<Groupe,Integer> gdao           = null;
        IDao<Student,String> sdao           = null;
        String sdaoClass, sserviceCLass, scontrollerClass , gdaoClass, gserviceCLass, gcontrollerClass;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        var config = cl.getResourceAsStream("config.properties");
        Properties propreties = new Properties();
        try {
            propreties.load(config);
            sdaoClass = propreties.getProperty("SDAO");
            sserviceCLass = propreties.getProperty("SSERVICE");
            scontrollerClass = propreties.getProperty("SCONTROLLER");

            gdaoClass = propreties.getProperty("GDAO");
            gserviceCLass = propreties.getProperty("GSERVICE");
            gcontrollerClass = propreties.getProperty("GCONTROLLER");
            config.close();
        } catch (IOException e){
            throw new Exception("Problème de chargement des propriétes du fichier config");
        } finally {
            propreties.clear();
        }
        try {
            Class gcDAO          = Class.forName(gdaoClass);
            Class gcService      = Class.forName(gserviceCLass);
            Class gcController   = Class.forName(gcontrollerClass);

            Class scDAO          = Class.forName(sdaoClass);
            Class scService      = Class.forName(sserviceCLass);
            Class scController   = Class.forName(scontrollerClass);


            gController = (IGroupeController) gcController.getDeclaredConstructor().newInstance();
            gservice    = (IGroupeMetier) gcService.getDeclaredConstructor().newInstance();
            gdao        = (IDao<Groupe, Integer>)gcDAO.getDeclaredConstructor().newInstance();
            Method setDao   = gcService.getMethod("setDao" , IDao.class);
            setDao.invoke(gservice , gdao);
            Method setService= gcController.getMethod("setMetier" , IGroupeMetier.class);
            setService.invoke(gController , gservice);
            gController.afficherNoteGenerale(1);


            sController = (IStudentController) scController.getDeclaredConstructor().newInstance();
            sservice    = (IStudentMetier) scService.getDeclaredConstructor().newInstance();
            sdao        = (IDao<Student, String>)scDAO.getDeclaredConstructor().newInstance();
            Method ssetDao   = scService.getMethod("setDao" , IDao.class);
            ssetDao.invoke(sservice , sdao);
            Method ssetService= scController.getMethod("setMetier" , IStudentMetier.class);
            ssetService.invoke(sController , sservice);
            sController.afficherNoteGeneral("V02");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void test3() throws ClassNotFoundException {
        gController = null;
        sController = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        gController = (IGroupeController) context.getBean("gcontroller");
        gController.afficherNoteGenerale(1);
        sController = (IStudentController) context.getBean("scontroller");
        sController.afficherNoteGeneral("V01");

    }

    public static void test4() throws ClassNotFoundException {
        gController = null;
        sController = null;
        ApplicationContext context      = new AnnotationConfigApplicationContext("dao.DsVolatile","metier","presentation");
        gController   = (IGroupeController) context.getBean(IGroupeController.class);
        gController.afficherNoteGenerale(1);
        sController   = (IStudentController) context.getBean(IStudentController.class);
        sController.afficherNoteGeneral("A01");
    }

    public static void main(String[] args) throws Exception {
        test2();
    }
}
