interface HeapStringInterface  {  // reprezentujte Max-heap haldu, kore� haldy je max
    public String first();        // vr�ti najv��� prvok z haldy
    public String remove();        // odstr�ni najv��� prvok z haldy
    public void insert(String str);// prid� prvok str do haldy, halda zostane haldou
    public int size();            // vr�ti ve�kos� haldy, po�et prvkov
}