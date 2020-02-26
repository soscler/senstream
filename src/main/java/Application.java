import engine.WeatherSensorAbs;
import io.javalin.Javalin;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        WeatherSensorAbs sensor = new WeatherSensorAbs(1, 0.0, 35.0);
        System.out.println("Start weather temperature generation...");
        sensor.generate(2).toString();

        System.out.println("Stop weather temperature generation...");
    }

    static void server() {
        Javalin app = Javalin.create(config -> {
            config.requestLogger((ctx, msg) -> {
                System.out.println("ctx: " + ctx + " , msg: " + msg);
            });
        });


        String message = "{\n"+
                "data1: 5.02\n" +
                "data2: 5.03\n}";

        String headers = "{ + \n" +
                "'Content-Type': 'text/event-stream',\n" +
                "    'Connection': 'keep-alive',\n" +
                "    'Cache-Control': 'no-cache'\n" +
                "}";

        app.sse("/sse/*", client -> {

            System.out.println(client.ctx.req.getQueryString());
            client.sendEvent("update", message);
            client.onClose(() -> {
                System.out.println("Client closed");
            });
            //client.sendEvent(message);
        });

        app.start(3000);
    }
}
