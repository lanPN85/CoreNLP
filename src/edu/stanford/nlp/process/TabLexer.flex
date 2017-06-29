package edu.stanford.nlp.international.vietnamese;

import edu.stanford.nlp.process.LexedTokenFactory;

import java.io.Reader;

/** Provides a Unicode-aware plain tab tokenizer.
 *  Designed to be called by <code>TabTokenizer</code>.
 */

%%

%class TabLexer
%unicode
%function next
%type Object
%char

%{
/**
 * See: http://www.w3.org/TR/newline on Web newline chars: NEL, LS, PS.
   See: http://unicode.org/reports/tr13/tr13-9.html and
   http://www.unicode.org/unicode/reports/tr18/#Line_Boundaries
   for Unicode conventions,
   including other separators (vertical tab and form feed).
   <br>
   We do not interpret the zero width joiner/non-joiner (U+200C,
   U+200D) as white spaces.
   <br>
   No longer %standalone.  See WhitespaceTokenizer for a main method.
 */

  public TabLexer(Reader r, LexedTokenFactory<?> tf) {
    this(r);
    this.tokenFactory = tf;
  }

  private LexedTokenFactory<?> tokenFactory;

  static final String NEWLINE = "\n";
%}

SPACE = [\t]
SPACES = {SPACE}+
TEXT = [^\t]+

%%

{SPACES} { }
{TEXT}   { return tokenFactory.makeToken(yytext(), yychar, yylength()); }
<<EOF>>  { return null; }
