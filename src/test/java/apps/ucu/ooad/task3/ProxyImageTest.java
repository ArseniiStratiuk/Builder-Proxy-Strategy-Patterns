package apps.ucu.ooad.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class ProxyImageTest {

    @Test
    void imageInstantiatedLazilyAndOnlyOnce() {
        AtomicInteger creations = new AtomicInteger();
        AtomicInteger displays = new AtomicInteger();

        ProxyImage proxyImage = new ProxyImage("demo.png", path -> {
            creations.incrementAndGet();
            return () -> displays.incrementAndGet();
        });

        proxyImage.display();
        proxyImage.display();

        assertEquals(1, creations.get(), "Real image should be created only once");
        assertEquals(2, displays.get(), "Display should be delegated each time");
    }
}
