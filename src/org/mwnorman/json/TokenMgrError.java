/* Generated By:JavaCC: Do not edit this line. TokenMgrError.java Version 5.0 */
/* JavaCCOptions: */
/*
 * This software is licensed under the terms of the ISC License.
 * (ISCL http://www.opensource.org/licenses/isc-license.txt
 * It is functionally equivalent to the 2-clause BSD licence,
 * with language "made unnecessary by the Berne convention" removed).
 *
 * Copyright (c) 2011-2013 Mike Norman
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER
 * RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT,
 * NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE
 * USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 ******************************************************************************/
package org.mwnorman.json;

/** Token Manager Error. */
@SuppressWarnings("all")
public class TokenMgrError extends Error
{

  /**
   * The version identifier for this Serializable class.
   * Increment only if the <i>serialized</i> form of the
   * class changes.
   */
  private static final long serialVersionUID = 1L;

  /*
   * Ordinals for various reasons why an Error of this type can be thrown.
   */

  /**
   * Lexical error occurred.
   */
  static final int LEXICAL_ERROR = 0;

  /**
   * An attempt was made to create a second instance of a static token manager.
   */
  static final int STATIC_LEXER_ERROR = 1;

  /**
   * Tried to change to an invalid lexical state.
   */
  static final int INVALID_LEXICAL_STATE = 2;

  /**
   * Detected (and bailed out of) an infinite loop in the token manager.
   */
  static final int LOOP_DETECTED = 3;

  /**
   * Indicates the reason why the exception is thrown. It will have
   * one of the above 4 values.
   */
  int errorCode;

  /**
   * Replaces unprintable characters by their escaped (or unicode escaped)
   * equivalents in the given string
   */
  protected static final String addEscapes(String str) {
    StringBuffer retval = new StringBuffer();
    char ch;
    for (int i = 0; i < str.length(); i++) {
      switch (str.charAt(i))
      {
        case 0 :
          continue;
        case '\b':
          retval.append("\\b");
          continue;
        case '\t':
          retval.append("\\t");
          continue;
        case '\n':
          retval.append("\\n");
          continue;
        case '\f':
          retval.append("\\f");
          continue;
        case '\r':
          retval.append("\\r");
          continue;
        case '\"':
          retval.append("\\\"");
          continue;
        case '\'':
          retval.append("\\\'");
          continue;
        case '\\':
          retval.append("\\\\");
          continue;
        default:
          if ((ch = str.charAt(i)) < 0x20 || ch > 0x7e) {
            String s = "0000" + Integer.toString(ch, 16);
            retval.append("\\u" + s.substring(s.length() - 4, s.length()));
          } else {
            retval.append(ch);
          }
          continue;
      }
    }
    return retval.toString();
  }

  /**
   * Returns a detailed message for the Error when it is thrown by the
   * token manager to indicate a lexical error.
   * Parameters :
   *    EOFSeen     : indicates if EOF caused the lexical error
   *    curLexState : lexical state in which this error occurred
   *    errorLine   : line number when the error occurred
   *    errorColumn : column number when the error occurred
   *    errorAfter  : prefix that was seen before this error occurred
   *    curchar     : the offending character
   * Note: You can customize the lexical error message by modifying this method.
   */
  protected static String LexicalError(boolean EOFSeen, int lexState, int errorLine, int errorColumn, String errorAfter, char curChar) {
    return("Lexical error at line " +
          errorLine + ", column " +
          errorColumn + ".  Encountered: " +
          (EOFSeen ? "<EOF> " : ("\"" + addEscapes(String.valueOf(curChar)) + "\"") + " (" + (int)curChar + "), ") +
          "after : \"" + addEscapes(errorAfter) + "\"");
  }

  /**
   * You can also modify the body of this method to customize your error messages.
   * For example, cases like LOOP_DETECTED and INVALID_LEXICAL_STATE are not
   * of end-users concern, so you can return something like :
   *
   *     "Internal Error : Please file a bug report .... "
   *
   * from this method for such cases in the release version of your parser.
   */
  public String getMessage() {
    return super.getMessage();
  }

  /*
   * Constructors of various flavors follow.
   */

  /** No arg constructor. */
  public TokenMgrError() {
  }

  /** Constructor with message and reason. */
  public TokenMgrError(String message, int reason) {
    super(message);
    errorCode = reason;
  }

  /** Full Constructor. */
  public TokenMgrError(boolean EOFSeen, int lexState, int errorLine, int errorColumn, String errorAfter, char curChar, int reason) {
    this(LexicalError(EOFSeen, lexState, errorLine, errorColumn, errorAfter, curChar), reason);
  }
}
/* JavaCC - OriginalChecksum=0435aa3bf7976a0489d581839d805b2d (do not edit this line) */
