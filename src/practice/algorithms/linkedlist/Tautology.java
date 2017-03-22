package practice.algorithms.linkedlist;

/* package whatever; // don't place package name! */
import java.io.*;
import java.util.*;
 
abstract class Formula {
 
 
    abstract public Formula toNnf();
 
    abstract public Formula nnfToCnf();
 
    public Formula simplifyCnf()  {
        return (new AND(this, T.VALUE)).simplifyCnf();
    }
 
   abstract protected Formula neg();
 
    abstract protected Vector toClause() ;;
 
    abstract public String toString();
}
 
abstract class Token {
	static final int DOLLAR = 8;
	static final int ATOM   = 7;
	static final int FALSE  = 6;
	static final int TRUE   = 5;
	static final int RPAREN = 4;
	static final int LPAREN = 3;
	static final int NEG    = 2;
	static final int CONJ   = 1;
	static final int DISJ   = 0;
 
	abstract int value();
	abstract public String toString();
}
 
abstract class Val extends Token {}
 
abstract class Literal extends Formula {
 
 
    public Formula toNnf() {
        return this;
    }
 
    public Formula nnfToCnf() {
        return this;
    }
 
    public Formula simplifyCnf() {
        return this;
    }
 
    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }
 
	abstract protected boolean isNeg(Formula formula);
 
}
 
class T extends Literal {
	public static final T VALUE = new T();
 
	private T() {}
	protected boolean isNeg(Formula formula) {
        	return formula == F.VALUE;
	}
 
	protected Formula neg() {
		return F.VALUE;
	}
 
	public String toString() {
		return "TRUE";
	}
}
 
class F extends Literal {
 
	public static final F VALUE = new F();
 
	private F() {}
 
	protected boolean isNeg(Formula formula) {
		return formula == T.VALUE;
	}
 
	protected Formula neg() {
        	return T.VALUE;
	}
 
	public String toString() {
		return "FALSE";
	}
}
 
class True extends Val {
 
	final int value() {
		return Token.TRUE;
	}
 
	public final String toString() {
		return "TRUE";
	}
}
 
class False extends Val {
	final int value() {
	        return Token.FALSE;
	}
 
	public final String toString() {
		return "FALSE";
	}
}
 
class Conj extends Token {
	final int value() {
		return Token.CONJ;
    	}
 
	public final String toString() {
		return "CONJ";
    }
}
 
class Disj extends Token {
	final int value() {
        	return Token.DISJ;
	}
 
	public final String toString() {
		return "DISJ";
	}
}
 
class Neg extends Token {
 
    final int value() {
        return Token.NEG;
    }
 
    public final String toString() {
        return "NEG";
    }
}
 
class RParen extends Token {
 
    final int value() {
        return Token.RPAREN;
    }
 
    public final String toString() {
        return ")";
    }
}
 
class LParen extends Token {
 
    final int value() {
        return Token.LPAREN;
    }
 
    public final String toString() {
        return "(";
    }
}
 
//ATOM is varaible in given expression
class Atom extends Val {
 
    final String literal;
 
    final int value() {
        return Token.ATOM;
    }
 
    Atom(final String literal) {
        this.literal = literal;
    }
 
    public final String toString() {
        return "Atom(" + this.literal +")";
    }
}
 
class Dollar extends Token {
 
    final int value() {
        return Token.DOLLAR;
    }
 
    public final String toString() {
        return "$";
    }
}
 
 
class Lexer {
 
	public  StringReader reader;
	public char lex_char;
	public String lex_text = null;
	public boolean lex_start = true;
	boolean isEol = false;
 
	Lexer(StringReader str) {
		reader = str;
        	lex_start = true;
        	isEol = false;
	}
 
	void advance() throws IOException {
       		int next_char = reader.read();
		if (next_char == -1) {
			isEol = true;
            		return;
 		}
		lex_char = (char)next_char;
		return;
       }
 
	Token lex() throws IOException {
 
	lex_text = null;
 
        // If we're at the start of the input stream,
        // advance and reset lex_start.
        if (lex_start) {
            advance();
            lex_start = false;
        }
 
        // If we're at the end of the input stream, return
        // the Eol Token.
        if (isEol) {
            return new Dollar();
        }
 
        // Skip whitespace.
        while (Character.isWhitespace(lex_char) && !isEol) {
            advance();
        }
 
        // Build lex_text.
        if (lex_char == '(') {
            lex_text = "(";
            advance();
        } else if (lex_char == ')' ) {
            lex_text = ")";
            advance();
	} else if(lex_char == '|') {
		lex_text = "OR";
        	advance();
	} else if( lex_char == '&') {
		lex_text = "AND";
		advance();
	} else if (lex_char == '!') {
		lex_text = "NOT";
		advance();
	} else if (Character.isLetter(lex_char)) {
            lex_text = (new Character(lex_char)).toString();
            advance();
        } else if (isEol) { // Catches whitespace immediately before an Eof.
            if (lex_text == null) {
                return new Dollar();
            }
	} else {
		System.out.println("not machting");
	 } 
 
		return textToToken();	
	}
 
 Token textToToken() {
 
	if (lex_text.equals("(")) {
            return new LParen();
        } else if (lex_text.equals(")")) {
            return new RParen();
        } else if (lex_text.equals("NOT")) {
            return new Neg();
        } else if (lex_text.equals("AND")) {
            return new Conj();
        } else if (lex_text.equals("OR")) {
            return new Disj();
        } else {
            return new Atom(lex_text);
        }
 
    }
}
 
	// Some deductive formulas
	//P OR NOT P    == TRUE
   	// P AND (P OR Q)   == P
     	//(P OR Q) AND (NOT P OR Q) == Q
 
 class AND extends Formula {
 
    private final Formula left;
    private final Formula right;
 
    public AND(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }
 
    protected Formula getLeft() {
        return this.left;
    }
 
    protected Formula getRight() {
        return this.right;
    }
 
    public Formula toNnf()  {
        return new AND(this.left.toNnf(), this.right.toNnf());
    }
 
    public Formula nnfToCnf()  {
        return new AND(this.left.nnfToCnf(), this.right.nnfToCnf());
    }	
 
   public Formula simplifyCnf() {
	Vector clausal = this.toClause();
 
        // Remove any clause containing a Literal and its negation.
        for (int i = 0; i < clausal.size(); i++) {
            Vector curr_disj = (Vector)clausal.elementAt(i);
            loop: for (int j = 0; j < curr_disj.size(); j++) {
                if (curr_disj.elementAt(j) instanceof Literal) {
                    Literal at_j = (Literal)curr_disj.elementAt(j);
                    for (int k = 0; k < curr_disj.size(); k++) {
                        Formula at_k = (Formula)curr_disj.elementAt(k);
                        if (at_j.isNeg(at_k)) {
                            clausal.removeElementAt(i--);
                            break loop;
                        }
                    }
                }
            }
        }
 
        // Remove any clause that is a superset of another clause.
        for (int i = 0; i < clausal.size() - 1; i++) {
            for (int j = i+1; j < clausal.size(); j++) {
                if (isSubset((Vector)clausal.elementAt(i),
                             (Vector)clausal.elementAt(j))) {
                    clausal.removeElementAt(j);
                } else if (isSubset((Vector)clausal.elementAt(j),
                                    (Vector)clausal.elementAt(i))) {
                    clausal.removeElementAt(i);
                }
            }
        }
 
        // Return a Formula.
        return fromClause(clausal);
	}
 
 	 private static boolean isSubset(Vector v1, Vector v2) {
        	for (int i = 0; i < v1.size(); i++) {
            		if (!v2.contains(v1.elementAt(i))) {
               	 return false;
            }
        }
        return true;
    }
 
  private static Formula fromClause(Vector clausal) {
        Formula conj = T.VALUE;
 
        for (int i = clausal.size(); i > 0; i--) {
            Formula disj = F.VALUE;
            Vector curr_disj = (Vector)clausal.elementAt(i-1);
 
            for (int j = curr_disj.size(); j > 0; j--) {
                Formula curr_lit = (Formula)curr_disj.elementAt(j-1);
                if (disj == F.VALUE) {
                    disj = curr_lit;
                } else {
                    disj = new OR(disj, curr_lit);
                }
            }
 
            if (conj == T.VALUE) {
                conj = disj;
            } else {
                conj = new AND(disj, conj);
            }
        }
 
        return conj;
    }
 
protected Vector toClause()  {
        Vector clause  = new Vector();
        Vector c_left;
        Vector c_right;
 
        if (this.left instanceof AND) {
            c_left = this.left.toClause();
            for (int i = 0; i < c_left.size(); i++) {
                clause.addElement(c_left.elementAt(i));
            }
        } else {
            c_left = this.left.toClause();
            clause.addElement(c_left);
        }
 
        if (this.right instanceof AND) {
            c_right = this.right.toClause();
            for (int i = 0; i < c_right.size(); i++) {
                clause.addElement(c_right.elementAt(i));
            }
        } else {
            c_right = this.right.toClause();
            clause.addElement(c_right);
        }
        return clause;
 }
 
protected Formula neg() {
        return new OR(this.left.neg(), this.right.neg());
    }
 
    public String toString() {
        return ("(" + this.left.toString() + " & "
                + this.right.toString() + ")");
    }
 
}
 
class OR extends Formula {
 
    private final Formula left;
    private final Formula right;
 
    public OR(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }
 
    protected Formula getLeft() {
        return this.left;
    }
 
    protected Formula getRight() {
        return this.right;
    }
 
   public Formula toNnf()  {
        return new OR(this.left.toNnf(), this.right.toNnf());
    }
 
    public Formula nnfToCnf()  {
        Formula left = this.left.nnfToCnf();
        Formula right = this.right.nnfToCnf();
 
        if (left instanceof AND) {
            AND conj = (AND)left;
            return new AND(new OR(conj.getLeft(), right).nnfToCnf(),
                            new OR(conj.getRight(), right).nnfToCnf());
        }
        else if (right instanceof AND) {
            AND conj = (AND)right;
            return new AND(new OR(left, conj.getLeft()).nnfToCnf(),
                            new OR(left, conj.getRight()).nnfToCnf());
        }
        return new OR(left, right);
    }
 
    protected Vector toClause() {
        Vector clause  = new Vector();
        Vector c_left  = this.left.toClause();
        Vector c_right = this.right.toClause();
 
        for (int i = 0; i < c_left.size(); i++) {
            clause.addElement(c_left.elementAt(i));
        }
 
        for (int i = 0; i < c_right.size(); i++) {
            clause.addElement(c_right.elementAt(i));
        }
 
        return clause;
    }
 
    protected Formula neg() {
        return new AND(this.left.neg(), this.right.neg());
    }
 
    public String toString() {
        return ("(" + this.left.toString() + " | "
                + this.right.toString() + ")");
    }
 
}
 
 class NOT extends Formula {
 
    private final Formula term;
 
    public NOT(Formula term) {
        this.term = term;
    } 
 
    protected Formula getTerm() {
        return this.term;
    }
 
    public Formula toNnf()  {
        if (this.term instanceof AND ||
            this.term instanceof OR ||
            this.term instanceof NOT) {
 
            return this.term.neg().toNnf();
 
        } else if (this.term instanceof Literal) {
            return this;
        }
	return null; 
    }
 
	public Formula nnfToCnf()  {
 
        if (this.term instanceof Literal) {
            return this;
        }
	return null;
    }
 
    public Formula simplifyCnf()  {
        if (this.term instanceof Literal) {
            return this;
        }
	return null;
    }
 
    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }
 
    protected Formula neg() {
        return this.term;
    }
 
    public String toString() {
        return "!" + term.toString();
    }
 
} 
 
class Variable extends Literal {
 
    private final String name;
 
    public Variable(String name) {
        this.name = name;
    }
 
    protected String getName() {
        return name; 
    }     
 
    protected boolean isNeg(Formula formula) {
        if (formula instanceof NOT) {
            Formula term = ((NOT)formula).getTerm();
            if (term instanceof Variable) {
                return ((Variable)term).getName().equals(this.name);
            }
        }
        return false; 
    }
 
    protected Formula neg() {
        return new NOT(this);
    }
 
    public String toString() {
        return this.name;
    }
}
 
class Parser 
{
    private static Lexer lexer;	
    private static Token token = new Dollar();
 
    private static Formula absyn = null;
 
    private static Stack op_stack  = new Stack();
    private static Stack val_stack  = new Stack();
 
    private static final int S = 0;
   private static final int R = 1;
 
 
    private static final int E1 = 2;
 
    private static final int E2 = 3;
 
    private static final int E3 = 4;
 
    private static final int E4 = 5;
 
	  private static final int[][] o_p_table = {
        /*  ----------------------input token--------------------- */
        /*  -op_stk-    OR  AND NOT (   )   Val Val Val  $  */
        /*  ----------------------input token--------------------- */
        /*      OR */{   R,  S,  S,  S,  R,  S,  S,  S,  R },
        /*     AND */{   R,  R,  S,  S,  R,  S,  S,  S,  R },
        /*     NOT */{   R,  R,  S,  S,  R,  S,  S,  S,  R },
        /*       ( */{   S,  S,  S,  S,  S,  S,  S,  S,  E1},
        /*       ) */{   R,  R,  R,  E4, R,  S,  S,  S,  R },
        /*         */{ /* Vals aren't held on the op_stack but */},
        /*         */{ /* blank lines here mean we can look up */},
        /*         */{ /* Token.DOLLAR tokens correctly.       */},
        /*       $ */{  S,  S,  S,  S,  E2, S,  S,  S,  E3},
    };
 
  public Parser(StringReader input) throws IOException {
        lexer = new Lexer(input);
        op_stack.push(new Dollar());
       absyn = parse();
}
 
public Formula getAST() {
        return absyn;
    }
 
 public   Formula parse()
        throws IOException {
 
	token = lexer.lex();
 
	while (true) {
         // Check if we should accept the sentence.
        if (token.value() == Token.DOLLAR &&
            ((Token)op_stack.peek()).value() == Token.DOLLAR) {
 
	    return (Formula)val_stack.pop();
 
	}
 
 
	switch(o_p_table[((Token)op_stack.peek()).value()][token.value()]) {
        case S :
          shift();
          token = lexer.lex();
         break;
        case R :
         reduce();
          break;
	default :
        	break;
	}
 
	}
 
    }
 
 public  void shift() {
 
        // Input token is a value (True, False or Atom).
        if (token instanceof Val) {
	  if (token.value() == Token.ATOM) {
                val_stack.push(new Variable(((Atom)token).literal));
            }
        } else {
            // Input token is an operator (Conj, Disj, Not, (, ), $).
            op_stack.push(token);
        }
 
        return;
    }
 
public  void reduce() {
 
      switch (((Token)op_stack.pop()).value()) {
      case Token.NEG :
        val_stack.push(new NOT((Formula)val_stack.pop()));
        break;
      case Token.RPAREN :
        op_stack.pop(); // Pop an LParen
        break;
      case Token.CONJ :
        {
          Formula temp = (Formula)val_stack.pop();
          val_stack.push(new AND((Formula)val_stack.pop(),
                                              temp));
        }
        break;
      case Token.DISJ :
        {
           Formula temp = (Formula)val_stack.pop();
	   val_stack.push(new OR((Formula)val_stack.pop(), temp));
 
	}
       default:
		 break;
      }
 
      return;
   }
}
 
public class Tautology
{
 
public static void main(String ar[]) throws IOException
{
	int i = 0;
	Parser myParser;
	Formula  formula;	
	StringReader reader; 
 
	String  expr[] = {"(!a | (a & a))", "(!a | (b & !a))","(!a | a)","( a & ( !b | b)) | ( !a & ( !b |b ))"};
 
	for ( i = 0; i < expr.length ; i++)
        {
		reader = new StringReader(expr[i]);
		myParser = new Parser(reader);
		formula = myParser.getAST();	
 
		System.out.println("Formula = "+ formula.toString());
 
		formula = formula.toNnf();
		System.out.println("toNnf Formula = "+ formula.toString());
 
		// Convert to CNF
        	formula = formula.nnfToCnf();
            	System.out.println("to nntoCNF ="+formula.toString());
 
        	// Simplify
        	formula = formula.simplifyCnf();
            	System.out.println("simplified ="+formula.toString());
 
		if(T.VALUE == formula)
			System.out.println("Tautology");
		else
			System.out.println("not Tautology");
 
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
	}
 }
}
 