package de.shop.util;

import static de.shop.util.Constants.REST_PATH;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(REST_PATH)
public class JaxRsActivator extends Application {
}
