import java.util.*;
import java.util.stream.Collectors;

public class Spoje {

    public static <V> List<V> destinacie(Map<V, Set<V>> spoje) {
        List<V> res = new ArrayList<>();
        spoje.forEach((v, dest) -> {
                    if (dest != null) // zbytocne, podla predpokladov
                        res.addAll(dest);
                }
        );
        return res;
    }

    public static <V> Map<V, Set<V>> opacne(Map<V, Set<V>> spoje) {
        Map<V, Set<V>> res = new HashMap<V, Set<V>>();
        for (V v : spoje.keySet()) {
            if (spoje.get(v) != null)   // zbytocne
                for (V w : spoje.get(v)) {
                    Set<V> x = res.get(w);
                    if (x == null)
                        x = new HashSet<>();
                    x.add(v);
                    res.put(w, x);
                }
        }
        return res;
    }

    public static <V> Map<V, Set<V>> bezPrestupu(Map<V, Set<V>> vlaky, Map<V, Set<V>> busy) {
        Map<V, Set<V>> res = new HashMap<V, Set<V>>();
        for(V v:vlaky.keySet()) {
            if (vlaky.get(v) != null) {     // zbytcne
                Set<V> x = res.get(v);
                if (x == null)
                    x = new HashSet<>();
                x.addAll(vlaky.get(v));
                res.put(v, x);
            }
        }
        return res;
    }

    public static <V> Map<V, Set<V>> sPrestupom(Map<V, Set<V>> vlaky, Map<V, Set<V>> busy) {
        Map<V, Set<V>> res = new HashMap<V, Set<V>>();
        for(V v:vlaky.keySet()) {
            if (vlaky.get(v) != null)  // zbytocne
                res.put(v,
                        vlaky.get(v).stream()
                                .filter(p -> busy.get(p) != null)   // zbytocne
                                .flatMap(p -> busy.get(p).stream()).collect(Collectors.toSet())
                );
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, Set<String>> vlak = Map.of(
                "ZA", Set.of("BB", "BA","KE", "PO"),
                "BA", Set.of("ZA", "NR", "BB", "KE"),
                "BB", Set.of("KE", "ZA"),
                "KE", Set.of("ZA", "PO")
        );
        System.out.println("opacne:" + opacne(vlak));
        Map<String, Set<String>> bus = Map.of(
                "BA", Set.of("ZA", "KE"),
                "ZA", Set.of("KE"));
        System.out.println("s prestupom:" + sPrestupom(vlak, bus));
    }
}