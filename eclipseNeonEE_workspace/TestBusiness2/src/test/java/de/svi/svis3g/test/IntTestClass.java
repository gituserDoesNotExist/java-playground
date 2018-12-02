/// *
// * Created on 23.08.2018
// *
// * Dimensions - Versionierung
// * $Workfile: %PM% $
// * $Revision: %PR% $
// * $Date: %Date% $
// * $Author: %Author% $
// *
// * (c) Copyright SV Informatik GmbH 2010
// */
//
// package de.svi.svis3g.test;
//
// import static org.junit.Assert.assertTrue;
//
// import java.io.File;
//
// import org.apache.log4j.Logger;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.TestPropertySource;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
/// **
// * Zweck dieser Klasse: <br>
// * Test.
// *
// * @author N0008244
// */
// @RunWith(SpringJUnit4ClassRunner.class)
// @TestPropertySource(locations = { "classpath:environment.properties", "classpath:consumerServices.properties" })
// @ContextConfiguration("classpath:application-context/global-test.xml")
// public class IntTestClass {
//
// private static final Logger LOGGER = Logger.getLogger(IntTestClass.class);
//
// // @Autowired
// // private AntragVerwaltungClient client;
//
// @Test
// @SuppressWarnings("javadoc")
// public void testName() {
// printClassPathFolders();
//
// assertTrue(true);
// }
//
// @SuppressWarnings("unused")
// private void printClassPathFolders() {
// String[] property = System.getProperty("java.class.path").split(File.pathSeparator);
// for (String string : property) {
// System.out.println(string);
// }
// }
//
// }
