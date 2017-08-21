package mb;

import javax.faces.bean.ManagedBean;

/**
 * Created by Maria on 19.08.2017.
 */
@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {
    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

    public String getMessage() {
        return "Hello World!";
    }
}

