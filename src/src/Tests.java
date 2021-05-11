import org.junit.*;

public class Tests {
    @Test(expected = NullPointerException.class)
    public void test_null(){
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void test_empty_string() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void test_not_a_number() {
        Integer.decode("five");
    }

    @Test
    public void test_negative(){
        Assert.assertEquals(-1, Integer.decode("-1").longValue());
    }

    @Test
    public void test_positive_with_plus(){
        Assert.assertEquals(1, Integer.decode("+1").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void test_wrong_sign_position(){
        Integer.decode("+ 1");
    }

    @Test(expected = NumberFormatException.class)
    public void test_sign_without_number(){
        Integer.decode("+");
    }

    @Test
    public void test_positive(){
        Assert.assertEquals(1, Integer.decode("1").longValue());
    }

    @Test
    public void test_starts_with_0x_is_16_radix(){
        Assert.assertEquals(10, Integer.decode("0xA").longValue());
    }

    @Test
    public void test_starts_with_0X_is_16_radix(){
        Assert.assertEquals(47890, Integer.decode("0XBB12").longValue());
    }

    @Test
    public void test_starts_with_sharp_is_16_radix(){
        Assert.assertEquals(44252, Integer.decode("#ACDC").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void test_16_radix_wrong_symbols_throw_exception(){
        Integer.decode("#AW");
    }

    @Test
    public void test_16_radix_ignore_case(){
        Assert.assertEquals(44252, Integer.decode("#ACdc").longValue());
    }

    @Test
    public void test_starts_with_zero_is_8_radix(){
        Assert.assertEquals(8, Integer.decode("010").longValue());
    }

    @Test
    public void test_one_zero_is_zero(){
        Assert.assertEquals(0, Integer.decode("0").longValue());
    }

    @Test(expected = NumberFormatException.class)
    public void test_8_radix_wrong_symbols_throws_exception(){
        Integer.decode("01F");
    };
}
