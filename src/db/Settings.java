/*
 * The MIT License
 *
 * Copyright 2015 Ryan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package db;

/**
 *
 * @author Ryan
 */
public class Settings {
    private static String dbdriver = "com.mysql.jdbc.Driver";
    private static String user = "switcher";
    private static String pass = "duJU92Ca";
    private static String url = "jdbc:mysql://192.168.1.2:3306/fire_tickets";

    public static String getDbdriver() {
        return dbdriver;
    }

    public static void setDbdriver(String aDbdriver) {
        dbdriver = aDbdriver;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String aUser) {
        user = aUser;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String aPass) {
        pass = aPass;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String aUrl) {
        url = aUrl;
    }
    
}
