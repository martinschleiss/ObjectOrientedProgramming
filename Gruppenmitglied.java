import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface Gruppenmitglied {

	String value() default "Chuck Norris"; //Name des Verantwortlichen, fuer mehrere Verantwortliche auch String[] value realisierbar
}

