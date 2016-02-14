package module3.abstractFactory;

import static org.junit.Assert.*;

import org.junit.Test;

import com.epam.training.module3.models.FileSource;

public class ExampleTest {

  private FileSource fileSource;

  public ExampleTest() {
    fileSource = new FileSource();
  }

  @Test
  public void testReadPerson() {
    assertEquals(fileSource.readPerson("Kondrat").getName(), "Kondrat");
  }

}
