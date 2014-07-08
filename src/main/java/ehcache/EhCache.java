package ehcache;


import com.sun.tools.internal.jxc.ap.Const;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.io.Serializable;

/**
 * Created by zdsoft on 14-6-18.
 */
public class EhCache {

    private static final String TEST_CACHE = "testCache";
    private static final String KEY1 = "key1";
    private static final String KEY2 = "key2";

    public static void main(String[] args){

        System.out.print(1);

        CacheManager singletonManger = CacheManager.create();
        Cache memoryOnlyCache = new Cache(TEST_CACHE, 5000, false, false, 5, 2);
        singletonManger.addCache(memoryOnlyCache);
        Cache cache = singletonManger.getCache(TEST_CACHE);

        Element element = new Element(KEY1, "value1");
        cache.put(element);
        cache.put(new Element(KEY1, "value2"));
        cache.put(new Element(KEY2, "value3"));

        element = cache.get(KEY1);
        Serializable value = (Serializable)element.getObjectValue();
        System.out.println("value=" + value);

        int elementsInMemory = cache.getSize();
        System.out.println("elementsInMemory=" + elementsInMemory);

        long elementsInMemory2 = cache.getMemoryStoreSize();
        System.out.println("elementsInMemory2=" + elementsInMemory2);

        Object obj = element.getObjectValue();
        cache.remove(KEY1);
        System.out.println("obj="+obj);

        singletonManger.shutdown();

        System.out.print(2);

    }

}
