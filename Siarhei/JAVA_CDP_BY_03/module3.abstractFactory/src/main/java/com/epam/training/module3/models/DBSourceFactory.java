package com.epam.training.module3.models;

import com.epam.training.module3.factoryInterface.AbstractSourceFactory;
import com.epam.training.module3.sourceInterface.Source;

public class DBSourceFactory implements AbstractSourceFactory {

  public Source createSource() {

    return new DBSource();
  }

}
