/* Generated By:JJTree&JavaCC: Do not edit this line. JSONParser.java */
/*
 * This software is licensed under the terms of the ISC License.
 * (ISCL http://www.opensource.org/licenses/isc-license.txt
 * It is functionally equivalent to the 2-clause BSD licence,
 * with language "made unnecessary by the Berne convention" removed).
 * 
 * Copyright (c) 2011, Mike Norman
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
 */
package org.mwnorman.json;

//javase imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class JSONParser/*@bgen(jjtree)*/implements JSONParserTreeConstants, JSONParserConstants {/*@bgen(jjtree)*/
  protected JJTJSONParserState jjtree = new JJTJSONParserState();
    public JSONParser() {
        super();
    }

  final public Object parse() throws ParseException {
Object o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case O_OPENBRACE:
      o = object();
      break;
    case O_OPENBRACKET:
      o = array();
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  final public Object object() throws ParseException {
Map<String, Object> m = new LinkedHashMap<String, Object>();
    jj_consume_token(O_OPENBRACE);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case O_COLON:
    case UNQUOTED_STRING:
    case STRING:
      members(m);
      break;
    default:
      ;
    }
    jj_consume_token(O_CLOSEBRACE);
        {if (true) return m;}
    throw new Error("Missing return statement in function");
  }

  final public void members(Map<String, Object> m) throws ParseException {
    pair(m);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case O_COMMA:
      jj_consume_token(O_COMMA);
      members(m);
      break;
    default:
      ;
    }
  }

  final public void pair(Map<String, Object> m) throws ParseException {
Token t = null;
Object o;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case UNQUOTED_STRING:
    case STRING:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNQUOTED_STRING:
        t = jj_consume_token(UNQUOTED_STRING);
        break;
      case STRING:
        t = jj_consume_token(STRING);
        break;
      default:
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      ;
    }
    jj_consume_token(O_COLON);
    o = value();
        m.put(t.image, o);
  }

  final public Object array() throws ParseException {
List<Object> a=new ArrayList<Object>();
    jj_consume_token(O_OPENBRACKET);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case K_TRUE:
    case K_FALSE:
    case K_NULL:
    case O_OPENBRACE:
    case O_OPENBRACKET:
    case NUMBER:
    case STRING:
      elements(a);
      break;
    default:
      ;
    }
    jj_consume_token(O_CLOSEBRACKET);
        Collections.reverse(a);
        {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  final public void elements(List<Object> a) throws ParseException {
Object o = null;
    o = value();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case O_COMMA:
      jj_consume_token(O_COMMA);
      elements(a);
      break;
    default:
      ;
    }
        a.add(o);
  }

  final public Object value() throws ParseException {
Token t = null;
Object o = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case O_OPENBRACE:
      o = object();
      break;
    case O_OPENBRACKET:
      o = array();
      break;
    case STRING:
      t = jj_consume_token(STRING);
                    o = t.image;
      break;
    case NUMBER:
      t = jj_consume_token(NUMBER);
            try {
              o = Integer.valueOf(t.image);

            }
            catch (NumberFormatException nfe1) {
                try {
                    o = Long.valueOf(t.image);
                }
                catch (NumberFormatException nfe2) {
                    try {
                        o = Float.valueOf(t.image);
                    }
                    catch (NumberFormatException nfe3) {
                        try {
                            o = Double.valueOf(t.image);
                        }
                        catch  (NumberFormatException nfe4) {
                            o = Double.NaN;
                        }
                    }
                }

            }
      break;
    case K_TRUE:
      jj_consume_token(K_TRUE);
                  o = Boolean.TRUE;
      break;
    case K_FALSE:
      jj_consume_token(K_FALSE);
                   o = Boolean.TRUE;
      break;
    case K_NULL:
      jj_consume_token(K_NULL);
      break;
    default:
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return o;}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public JSONParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;

  /** Constructor with InputStream. */
  public JSONParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public JSONParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new JSONParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
  }

  /** Constructor. */
  public JSONParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new JSONParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
  }

  /** Constructor with generated Token Manager. */
  public JSONParser(JSONParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
  }

  /** Reinitialise. */
  public void ReInit(JSONParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      return token;
    }
    token = oldToken;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    Token errortok = token.next;
    int line = errortok.beginLine, column = errortok.beginColumn;
    String mess = (errortok.kind == 0) ? tokenImage[0] : errortok.image;
    return new ParseException("Parse error at line " + line + ", column " + column + ".  Encountered: " + mess);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
