package hello.helloSpring.web.accout.frame;

import java.util.List;

public interface FrameService<K,V> {
    public void register(V v) throws Exception;
    public void remove(K k) throws Exception;
    public void modify(V v) throws Exception;

    public List<V> get() throws Exception;
    public V get(K k) throws Exception;
}
