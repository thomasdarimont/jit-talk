package de.codecentric.interfaces;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InterfaceBenchmark1 {

  private static class Point implements Shape {

    @Override
    public int getPoints() {
      return 1;
    }

  }

  Shape[] shapes;

  @Setup
  public void prepare() {
    shapes = new Shape[Shape.ARRAY_SIZE];
    for (int i = 0; i < Shape.ARRAY_SIZE; i++) {
      shapes[i] = new Point();
    }
  }

  @Benchmark
  public long testSingleShape() {
    long sum = 0;
    for (int i = 0; i < Shape.ARRAY_SIZE; i++) {
      sum += shapes[i].getPoints();
    }
    return sum;
  }

}
