package com.sergiopz.xpathquerytool.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class MyCustomFilter extends FileFilter {
  public boolean accept(File file) {
    return (file.isDirectory() || file.getAbsolutePath().endsWith(".xml"));
  }
  
  public String getDescription() {
    return "XML documents (*.xml)";
  }
}
