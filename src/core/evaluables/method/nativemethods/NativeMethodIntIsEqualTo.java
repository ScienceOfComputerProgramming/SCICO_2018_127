package core.evaluables.method.nativemethods;

import core.Evaluable;
import core.ObjectBag;
import core.Runtime;
import core.evaluables.method.NativeMethod;
import core.exceps.InterpretError;
import core.objs.ObjectInt;
import core.objs.ObjectReal;

/**
 * Compare two numbers.
 * User: baltasarq
 * Date: 11/30/12
 */
public class NativeMethodIntIsEqualTo extends NativeMethod {

    public static final String EtqMthIntIsEqualTo = "==";

    public NativeMethodIntIsEqualTo()
    {
        super( EtqMthIntIsEqualTo );
    }

    @Override
    public ObjectBag doIt(ObjectBag ref, Evaluable[] params, StringBuilder msg)
            throws InterpretError
    {
        boolean result;
        final Runtime rt = Runtime.getRuntime();
        final ObjectInt self;

        chkParametersNumber( 1, params );

        try {
            self = (ObjectInt) ref;
        }
        catch(Exception exc)
        {
            throw new InterpretError( "self object should be an Int" );
        }

        final ObjectBag arg = rt.solveToObject( params[ 0 ] );

        if ( arg instanceof ObjectInt ) {
            result = ( self.getValue() == ( (ObjectInt) arg ).getValue() );
        }
        else
        if ( arg instanceof ObjectReal) {
            result = ( self.getValue() == Math.round( ( (ObjectReal) arg ).getValue() ) );
        } else {
            throw new InterpretError(
                    "expected int as parameter in '"
                    + params[ 0 ].toString()
                    + '\''
            );
        }


        msg.append( Boolean.toString( result ) );
        return rt.createBool( result );
    }
}
