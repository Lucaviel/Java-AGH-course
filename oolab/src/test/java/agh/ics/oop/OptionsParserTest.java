package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OptionsParserTest {

    @Test
    void parserTest(){
        OptionsParser optionParser=new OptionsParser();

        String[] strTest1 = new String[] {"r", "right", "f","right","l","left","kotek","forward","r"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parser(strTest1));

        String[] strTest2 = new String[] {"statek"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parser(strTest2));
    }
}
