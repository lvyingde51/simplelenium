/**
 * Copyright (C) 2013-2014 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.simplelenium.text;

import org.openqa.selenium.By;

public abstract class Text {
  private Text() {
    // Static utility class
  }

  public static String doesOrNot(boolean not, String verb) {
    if (!verb.contains(" ")) {
      if (not) {
        return "doesn't " + verb;
      } else if (verb.endsWith("h")) {
        return verb + "es";
      } else {
        return verb + "s";
      }
    }

    String[] verbs = verb.split("[ ]");
    verbs[0] = doesOrNot(not, verbs[0]);

    return String.join(" ", verbs);
  }

  public static String isOrNot(boolean not, String state) {
    if (not) {
      return "is not " + state;
    } else {
      return "is " + state;
    }
  }

  public static String hasOrNot(boolean not, String what) {
    if (not) {
      return "has " + what;
    } else {
      return "hasn't " + what;
    }
  }

  public static String plural(int n, String word) {
    if (n <= 1) {
      return n + " " + word;
    } else {
      return n + " " + word + "s";
    }
  }

  public static String toString(By selector) {
    return selector.toString().replace("By.selector: ", "");
  }
}
