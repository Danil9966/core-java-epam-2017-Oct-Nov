package com.epam.courses.jf.practice.akunats.second;

import com.epam.courses.jf.practice.common.second.ITestableTask14;
import org.junit.Assert;

public class Task9Test extends AbstractTaskWithResourcesTest {
    /**
     * Создание пустой коллекции.
     */
    @org.junit.Test(timeout = 2000)
    public void test1() throws Exception {
        // Prepare
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<Double> collection = solver.createCollection(Double.class);

        // Asserts
        Assert.assertTrue("Collection isn't empty", collection.isEmpty());
    }

    /**
     * Добавление элементов.
     */
    @org.junit.Test(timeout = 2000)
    public void test2() throws Exception {
        // Prepare
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<Double> collection = solver.createCollection(Double.class);
        collection.add(10d);

        // Asserts
        Assert.assertTrue(collection.contains(10d));
    }

    /**
     * Удаление элемента.
     */
    @org.junit.Test(timeout = 2000)
    public void test3() throws Exception {
        // Prepare
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<Double> collection = solver.createCollection(Double.class);
        collection.add(10d);

        // Asserts
        Assert.assertTrue(collection.contains(10d));
    }

    /**
     * Поиск совпадающего элемента.
     */
    @org.junit.Test(timeout = 2000)
    public void test4() throws Exception {
        // Prepare
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<Double> collection = solver.createCollection(Double.class);
        collection.add(10d);
        collection.add(15d);
        Double nearest = collection.nearest(10d);

        // Asserts
        Assert.assertEquals(10d, nearest, 0.001);
    }

    /**
     * Поиск несовпадающего элемента.
     */
    @org.junit.Test(timeout = 2000)
    public void test5() throws Exception {
        // Prepare
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<Double> collection = solver.createCollection(Double.class);
        collection.add(Double.MAX_VALUE);
        collection.add(15d);
        Double nearest = collection.nearest(12.3d);

        // Asserts
        Assert.assertEquals(15d, nearest, 0.001);
    }

    /**
     * Нестандартный Number.
     */
    @org.junit.Test()
    public void test6() throws Exception {
        // Prepare
        class FloatWrapper extends Number {

            private final float VALUE;

            FloatWrapper(float value) {
                VALUE = value;
            }

            @Override
            public int intValue() {
                return (int) VALUE;
            }

            @Override
            public long longValue() {
                return (long) VALUE;
            }

            @Override
            public float floatValue() {
                return VALUE;
            }

            @Override
            public double doubleValue() {
                return VALUE;
            }
        }
        ITestableTask14 solver = new Task14();

        // Run
        ITestableTask14.INumberCollection<FloatWrapper> collection = solver.createCollection(FloatWrapper.class);
        collection.add(new FloatWrapper(10));
        collection.add(new FloatWrapper(15));
        FloatWrapper nearest = collection.nearest(new FloatWrapper(12.3f));

        // Asserts
        Assert.assertEquals(10d, nearest.floatValue(), 0.001);
    }
}