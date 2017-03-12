

http://enos.itcollege.ee/~mimangus/java48/

<!--excerpt-->

### 11.03.2014

**Raamistikud**

* Swing - desktop raamistik
* JavaFX - desktop raamistik java 8. 3D, erinevad platvormid.
* JUnit - unit testing
* Maven - dependency management system
* Hibernate - tõlgendab relatsiooniliste andmebaaside olemeid java objektideks ja vastupidi
* Spring - 
* Wicket
* AspectJ - aspektorienteeritus, programm koosneb aspektidest.

**Java keel**

* C-põhine.
* Kompileeritult töötab kõikidel platvormidel.
* Eeldab java nimelist programmi, mis käivitab kompileeritud koodi. (java virtuaalmasin)
* Garbage collector
* objektorienteeritus, üsna rangelt alati. Iga klass eraldi samanimelises failis.
* rangelt tüübitud. Kompilaator annab vea, kui ei ole.

**Andmetüübid**

Väikese algustähega on primitiivtüübid, suure algustähega klassid.

**Lähenemine programmeerimisele**

ei ole õiget/valet, oluline on toimiv tulemus, loetavus.

**IDE**

Kuna Java kood on omavahel kõik rangelt lingitud, siis on IDE kasutamine mõistlik.

Eclipse - Window -> Perspective -> Java

Eclipse kompileerib faile, mis on src kataloogis.  
Pakett - kui on rohkem kui 1 klass, on mõistlik kasutada paketti.  
Paketi nimes . tähendab alampaketti/kataloogi, hea tava: ee.itcollege.parcticum1
Rea liigutamine Alt ja nooled.

**Ülesanne 1**


    package ee.itcollege.practicum1;

    public class Table {

        public static void main(String[] args) {

            int size = 10;

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
    //				if (col < row) {
    //					System.out.print((size - 1 -row) + " ");
    //				} else {
    //					System.out.print((size - 1 -col) + " ");
    //				}
    //				System.out.print((size - 1 - (col < row ? row : col)) + " ");
    //              System.out.print((size - 1 - Math.max(col, row)) + " ");
    //				System.out.format("%d ", (size - 1 - Math.max(col, row)));
    				System.out.print(String.format("%d ", (size - 1 - Math.max(col, row))));
                }
                System.out.println();
            }
        }
    }

**Ülesanne 2**

    package ee.itcollege.practicum1;

    import java.util.Scanner;

    public class SumOfDigits {


        public static void main(String[] args) {

            System.out.println("Insert a number");

            Scanner scanner = new Scanner(System.in);
            String number = scanner.nextLine();
            scanner.close();

            int sum = 0;

            for (int i = 0; i < number.length(); i++) {
    //			char c = number.charAt(i);
    //			sum += Character.digit(c, 10);
                Character c = number.charAt(i);
                try {
                    int digit = Integer.parseInt(c.toString());
                    sum += digit;
                }
                catch (NumberFormatException e) {}
            }

            System.out.println(sum);

        }
    }

**Ülesanne 3**

tetrise mäng JavaFX'ga.  
Main meetod kutsub välja klassi meetodi launch, mis käivitab meetodi start.  
Stage -> Scene -> Pane -> Block (figure)  

Maven, convert project to maven project. Lisame JUniti dependency. (http://junit.org/junit4/dependency-info.html)

https://raw.githubusercontent.com/murjam/tetris-fx/d131f29656cb7d59c1f9d474d33908fa5919d81d/src/ee/tthk/tetris/lib/FigureGenerator.java


**Hibernate**

ORM

Entity'le konstruktorit ei tehta enamasti.
src/META-INF/persistence.xml (http://enos.itcollege.ee/~mimangus/java48/day1/persistence.xml)

### 12.03.2014


* Serialiseerimine - objektide andmeteks teisendamine
* Deserialiseerimine - andmete objektideks teisendamine
* Jsoup - 
* Wicket - veebiraamistik. hea ülesehitusega, aga suure õppekõveraga, html pannakse serveril kokku. Puhas html ja java. Komponendipõhine.
* Spring - 


Generics - tüüpi saab defineerida klassile, samuti parameetrile.

Data.java

    package ee.itcollege.praktikum2;

    public class Data<T extends Number> {

        T object;

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        // kui tahad edastada klassi tüüpi
        public void doSmthg (Class<? extends T> clazz) {
            try {
                T newInst = clazz.newInstance();
            } catch (InstantiationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // tüübi definaarimine meetodi tagastusele ja parameetrile
        public <A extends String> A doSmthg2 (A str) {
            return str;
        }

    }


Generics.java


    package ee.itcollege.praktikum2;

    import java.util.ArrayList;

    public class Generics {

        public static void main(String[] args) {

    //		ArrayList<Integer> list = new ArrayList<>();
    //		
    //		list.add(12);
    //		
    //		Integer number = list.get(0);
    //		
    //		System.out.println(number);

            Data<Integer> data = new Data<Integer>();

            data.setObject(12);

            int id = data.getObject();

            System.out.println(id);

            String kala = data.doSmthg2("plah");

            System.out.println(kala);

        }

    }


**Ülesanne 1**

SortableList.java

    package ee.itcollege.praktikum2;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Collections;
    import java.util.Comparator;

    public class SortableList<T extends Comparable<T>> extends ArrayList<T> {

    //	public static <T extends Comparable<? super T>> void sort(List<T> list);

        public void sort() {
            Collections.sort(this);
        }

    }

Athlete.java

    package ee.itcollege.praktikum2;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Collections;
    import java.util.Comparator;

    public class SortableList<T extends Comparable<T>> extends ArrayList<T> {

    //	public static <T extends Comparable<? super T>> void sort(List<T> list);

        public void sort() {
            Collections.sort(this);
        }

    }

Generics.java

    package ee.itcollege.praktikum2;

    public class Generics {

        public static void main(String[] args) {

            SortableList<Athlete> list = new SortableList<Athlete>();
            list.add(new Athlete("Mati", 12.));
            list.add(new Athlete("Kati", 1.5));
            list.add(new Athlete("Tom", 122.));

            list.sort();

            for (Athlete athlete : list) {
                System.out.println(athlete);
            }

            // to stream
            list.stream()
                .filter(t -> t.getResult() > 10)
                .map(a -> a.getName())
                .forEach(Generics::handle);
        }

        private static void handle(String a) {
            // TODO Auto-generated method stub
            System.out.println(a);
        }

    }


**Ülesanne 2**

Serialization, deserialization - andmete objektiks ja via versa teisendamine. Ei sobi andmete pikaajaliseks hoidmiseks, kuna klass võib muutuda.

    package ee.itcollege.praktikum2;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;
    import java.util.Scanner;

    public class SportsDay {

        private static final String FILENAME = "athletes.dat";

        public static SortableList<Athlete> readList() {
            SortableList<Athlete> list;
            try {
                ObjectInputStream reader = new ObjectInputStream(new FileInputStream(new File(FILENAME)));
                list = (SortableList<Athlete>) reader.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                list = new SortableList<Athlete>();
            }
            return list;
        }

        private static void saveList(SortableList<Athlete> list) {
            try {
                ObjectOutputStream saver = new ObjectOutputStream(
                        new FileOutputStream(new File(FILENAME)));
                saver.writeObject(list);
                saver.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        public static void main(String[] args) {

            SortableList<Athlete> list = readList();

            for (Athlete athlete : list) {
                System.out.println(athlete);
            }

            System.out.println("Insert name");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Insert result");
            double result = scanner.nextDouble();
            scanner.close();

            list.add(new Athlete(name,  result));
            list.sort();
            saveList(list);

        }
    }


**Wicket**


* eclipse plugin: http://marketplace.eclipse.org/content/qwickie
* wicket quickstart: http://wicket.apache.org/start/quickstart.html

java

    package pages;

    import org.apache.wicket.request.mapper.parameter.PageParameters;
    import org.apache.wicket.util.time.Duration;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;
    import org.jsoup.select.Elements;
    import org.apache.wicket.markup.html.basic.Label;
    import org.apache.wicket.markup.html.link.BookmarkablePageLink;
    import org.apache.wicket.markup.html.link.Link;
    import org.apache.wicket.model.Model;

    import java.awt.Button;

    import org.apache.wicket.ajax.AjaxRequestTarget;
    import org.apache.wicket.ajax.AjaxSelfUpdatingTimerBehavior;
    import org.apache.wicket.ajax.markup.html.AjaxLink;
    import org.apache.wicket.markup.html.WebPage;

    public class HomePage extends WebPage {
        private static final long serialVersionUID = 1L;
    //	private int count = 0;

        private Model<Integer> count = new Model<>(0);

        private Model<String> titleModel = new Model<String>() {
            public String getObject () {
    //			".article-content_headline"

                try {
                    Document doc = Jsoup.connect("http://postimees.ee").get();
                    Elements headlines = doc.select(".article-content__headline");
                    int idx = (int)(headlines.size() * Math.random());
                    return headlines.get(idx).text();


                } catch (Exception e) {
                    return "doh";
                }


            }
        };

        private Label title = new Label("news", titleModel);

        private Label label = new Label("count", count) {
            @Override
            public boolean isVisible() {
                return count.getObject() % 2 == 0;
            }
        };

        public HomePage(final PageParameters parameters) {
            super(parameters);

            add(new BookmarkablePageLink<>("second-link", SecondPage.class));
            label.setOutputMarkupPlaceholderTag(true);
            label.setOutputMarkupId(true);
            add(label);
            // update every 5 sec with ajax
            title.add(new AjaxSelfUpdatingTimerBehavior(Duration.seconds(5)));

            add(title);

            add(new AjaxLink<Integer>("increase", count){
                @Override
                public void onClick(AjaxRequestTarget t) {
                    setModelObject(getModelObject() + 1);
                    t.add(label);
                }
            });



        }

    }



html

    <!DOCTYPE html>
    <html>
        <head>
            <meta charset="utf-8" />
            <title>Apache Wicket Quickstart</title>
            <link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:regular,bold' rel='stylesheet' type='text/css' />
            <link rel="stylesheet" href="style.css" type="text/css" media="screen" title="Stylesheet" />
        </head>
        <body>

            <p wicket:id="count"></p>
            <p>
                <a wicket:id="increase">Increase</a>
            </p>
            <p>
                <a wicket:id="second-link">Second page</a>
            </p>

            <div wicket:id="news">

            </div>

        </body>
    </html>



**Spring**

Dependency injection

**Aspect-Oriented programming AOP**

@Aspect_class
@Pointcut_
...

    package ee.itcollege.boot.aspect;

    import org.aspectj.lang.JoinPoint;
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.aspectj.lang.annotation.Pointcut;
    import org.springframework.stereotype.Component;

    @Aspect
    @Component
    public class LoggingAspect {

    //	@Pointcut("execution(* *..ProductController.list())")
        @Pointcut("execution(* *..*.list())")
        public void list() {}

    //	@Pointcut("execution(* *..ProductController.list())")
        @Pointcut("execution(public * *..*.*(..))")
        public void pub() {}

        @Pointcut("execution(* *..*Repository.*(..))")
        public void repo() {}

        @Before("list() && pub()")
        public void tere(JoinPoint jp) {
            // log
            System.out.println("tere " + jp.getTarget().getClass().getName());
        }

        @Before("execution(* *..ProductController.*(..))")
        public void log (JoinPoint jp) {
            // log
    //		System.out.println("tere " + jp.toLongString());	
            System.out.println("tere " + jp.toShortString());

        }

        @Around("repo()")
        public Object timer (ProceedingJoinPoint jp) throws Throwable {
            // log
            long t = System.currentTimeMillis();

            Object result = jp.proceed();

            System.out.format("call to %s took %dms", jp.toShortString(), System.currentTimeMillis() - t);

            return result;
        }
    }


**Annotatsioonid**

