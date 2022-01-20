package org.wocommunity.benchmarks;

import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;
import er.extensions.foundation.ERXProperties;
import org.openjdk.jmh.annotations.*;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 50, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1000, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgsAppend = {
        "-Dboolean.property.key=false",
        "-Darray.property.key=(1,2,3)",
        "-Dbigdecimal.property.key=123.45",
        "-Dlong.property.key=9999999999",
        "-Dstring.property.key=hello world",
        "-Denum.property.key=yellow",
        "-Dencrypted.property.key.encrypted=true",
        "-Dencrypted.property.key=363162130f5107dd",
        "-Ddictionary.property.key={a=b;c=d;}",
        "-Ddouble.property.key=123.456",
        "-Dfloat.property.key=789.123",
        "-Dint.property.key=123"
})
@BenchmarkMode(org.openjdk.jmh.annotations.Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(org.openjdk.jmh.annotations.Scope.Benchmark)
public class ERXPropertiesBench {
    @Setup
    public void setup() {
    }

    @Benchmark
    public boolean booleanForKey() {
        return ERXProperties.booleanForKey("boolean.property.key");
    }

    @Benchmark
    public NSArray<?> arrayForKey() {
        return ERXProperties.arrayForKey("array.property.key");
    }

    @Benchmark
    public BigDecimal bigDecimalForKey() {
        return ERXProperties.bigDecimalForKey("bigdecimal.property.key");
    }

    @Benchmark
    public long longForKey() {
        return ERXProperties.longForKey("long.property.key");
    }

    @Benchmark
    public String stringForKey() {
        return ERXProperties.stringForKey("string.property.key");
    }

    @Benchmark
    public Color enumValueForKey() {
        return ERXProperties.enumValueForKey(Color.class, "enum.property.key");
    }

    @Benchmark
    public String decryptedStringForKey() {
        return ERXProperties.decryptedStringForKey("encrypted.property.key");
    }

    @Benchmark
    public NSDictionary<?, ?> dictionaryForKey() {
        return ERXProperties.dictionaryForKey("dictionary.property.key");
    }

    @Benchmark
    public double doubleForKey() {
        return ERXProperties.doubleForKey("double.property.key");
    }

    @Benchmark
    public float floatForKey() {
        return ERXProperties.floatForKey("float.property.key");
    }

    @Benchmark
    public int intForKey() {
        return ERXProperties.intForKey("int.property.key");
    }

    @Benchmark
    public boolean hasKey() {
        return ERXProperties.hasKey("boolean.property.key");
    }

    public enum Color {
        BLUE, RED, YELLOW;
    }
}
