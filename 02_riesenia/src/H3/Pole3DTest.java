import static org.junit.Assert.*;

public class Pole3DTest {
    @org.junit.Test
    public void equalsIgnoreCase() throws Exception {
        String p1[][][] = {{{"a"}}};
        String p2[][][] = {{{"A"}}};
        assertEquals("test cislo 1", true, Pole3D.equalsIgnoreCase(p1,p2));

        assertFalse("test cislo 2",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{}, null, new String[][]{null}},
                        null
                ));

        assertFalse("test cislo 3",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{null, null}}}
                        ));

        assertFalse("test cislo 4",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Mariena"}}}
                ));

        assertTrue("test cislo 5",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Marienka"}}}
                ));

        assertFalse("test cislo 6",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}, null},
                        new String[][][]{{{"Janko", "Marienka"}}}
                ));

        assertFalse("test cislo 7",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Marienka"}, null}}
                ));

        assertFalse("test cislo 8",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Mariena"}}}
                ));

        assertFalse("test cislo 9",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Marienka", null}}}
                ));

        assertTrue("test cislo 10",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}}},
                        new String[][][]{{{}}}
                ));

        assertFalse("test cislo 11",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{null, {{"Janko", "Marienka"}}},
                        new String[][][]{{{"Janko", "Marienka"}}}
                ));

        assertFalse("test cislo 12",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{null, {"Janko", "Marienka"}}}
                ));

        assertFalse("test cislo 13",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{"Janko", "Marienka"}}},
                        new String[][][]{{{null, "Janko", "Marienka"}}}
                ));

        assertFalse("test cislo 14",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}}},
                        new String[][][]{{null}}
                ));

        assertFalse("test cislo 15",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{null}}},
                        new String[][][]{{null}}
                ));

        assertFalse("test cislo 16",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{null, null}},
                        new String[][][]{{null}}
                ));

        assertTrue("test cislo 17",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{null, null},
                        new String[][][]{null, null}
                ));

        assertTrue("test cislo 18",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}}},
                        new String[][][]{{{}}}
                ));

        assertTrue("test cislo 19",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}},
                        new String[][][]{{{}, {}}}
                ));

        assertFalse("test cislo 20",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}},
                        new String[][][]{{{}, {}}, {{}, {}}}
                ));

        assertTrue("test cislo 21",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}, {{}, {}}},
                        new String[][][]{{{}, {}}, {{}, {}}}
                ));

        assertTrue("test cislo 22",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}, {{}, {}}},
                        new String[][][]{{{}, {}}, {{}, {}}}
                ));

        assertFalse("test cislo 23",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}, {{}, {}}},
                        new String[][][]{{{}, {}}, {{null}, {}}}
                ));

        assertFalse("test cislo 24",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}, {{}, {}}},
                        new String[][][]{{{}, {}}, {{}, {}, null}}
                ));

        assertFalse("test cislo 25",
                Pole3D.equalsIgnoreCase(
                        new String[][][]{{{}, {}}, {{}, {}}},
                        new String[][][]{{{}, {}}, {{}, {}}, null}
                ));
    }

}