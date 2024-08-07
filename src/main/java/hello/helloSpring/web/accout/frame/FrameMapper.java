package hello.helloSpring.web.accout.frame;

import hello.helloSpring.web.notice.model.Notice;

import java.util.List;

public interface FrameMapper<K,V> {
    public void insert(V v) throws Exception;
    public void delete(K k) throws Exception;
    public void update(V v) throws Exception;

    public List<V> selectAll() throws Exception;
    public V select(K k) throws Exception;
}
