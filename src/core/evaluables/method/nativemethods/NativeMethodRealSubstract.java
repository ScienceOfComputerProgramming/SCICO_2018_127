package core.evaluables.method.nativemethods;

import core.Evaluable;
import core.ObjectBag;
import core.Runtime;
import core.evaluables.method.NativeMethod;
import core.exceps.InterpretError;
import core.objs.ObjectInt;
import core.objs.ObjectReal;

/**
 * Substract two numbers.
 * User: baltasarq
 * Date: 11/30/12
 */
public class NativeMethodRealSubstract extends NativeMethod {

    public static final String EtqMthRealSub = "-";

    public NativeMethodRealSubstract()
    {
        super( EtqMthRealSub );
    }

    @Override
    public ObjectBag doIt(ObjectBag ref, Evaluable[] params, StringBuilder msg)
            throws InterpretError
    {
        double result;
        final Runtime rt = Runtime.getRuntime();
        final ObjectReal self;
        final ObjectReal toret;

        chkParametersNumber( 1, params );

        try {
            self = (ObjectReal) ref;
        }
        catch(Exception exc)
        {
            throw new InterpretError( "self object should be a Real" );
        }

        final ObjectBag arg = rt.solveToObject( params[ 0 ] );

        if ( arg instanceof ObjectReal ) {
            result = self.getValue() - ( (ObjectReal) arg ).getValue();
        }
        else
        if ( arg instanceof ObjectInt) {
            result = ( self.getValue() - ( (ObjectInt) arg ).getValue() );
        } else {
            throw new InterpretError(
                    "expected Real as parameter in '"
                    + params[ 0 ].toString()
                    + '\''
            );
        }


        toret = rt.createReal( result );

        msg.append( self.getPath() );
        msg.append( " substracted from " );
        msg.append( arg.getPath() );
        msg.append( ", giving " );
        msg.append( toret.toString() );

        return toret;
    }
}
