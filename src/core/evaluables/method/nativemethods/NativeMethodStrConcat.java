package core.evaluables.method.nativemethods;

import core.Evaluable;
import core.ObjectBag;
import core.Runtime;
import core.evaluables.method.NativeMethod;
import core.exceps.InterpretError;
import core.objs.ObjectStr;

/**
 * To reside in Str, in order to concat two strings.
 * User: baltasarq
 * Date: 11/30/12
 */
public class NativeMethodStrConcat extends NativeMethod {

    public static final String EtqMthStrConcat = "+";

    public NativeMethodStrConcat()
    {
        super( EtqMthStrConcat );
    }

    @Override
    public ObjectBag doIt(ObjectBag ref, Evaluable[] params, StringBuilder msg)
            throws InterpretError
    {
        String result;
        final Runtime rt = Runtime.getRuntime();
        final ObjectStr self;
        final ObjectStr toret;

        chkParametersNumber( 1, params );

        try {
            self = (ObjectStr) ref;
        }
        catch(Exception exc)
        {
            throw new InterpretError( "self object should be an Str" );
        }

        final ObjectBag arg = rt.solveToObject( params[ 0 ] );

        if ( arg instanceof ObjectStr ) {
            result = self.getValue() + ( (ObjectStr) arg ).getValue();
        } else {
            throw new InterpretError(
                    "expected Str as parameter in '"
                    + params[ 0 ].toString()
                    + '\''
            );
        }

        toret = rt.createString( result );

        msg.append( self.getPath() );
        msg.append( " and " );
        msg.append( arg.getPath() );
        msg.append( " added, giving '" );
        msg.append( toret.toString() );
        msg.append( '\'' );

        return toret;
    }
}