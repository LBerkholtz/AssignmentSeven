package lberkholtz.advancedjava.assignmentseven.util;

import java.text.ParseException;

public class XMLParseException extends ParseException{

    /**
     *  Used to signal invalid Parse or other JAXB related issues.
     */

        /**
         * Constructs a new exception with the specified detail message,
         * cause, suppression enabled or disabled, and writable stack
         * trace enabled or disabled.
         *
         * @param message            the detail message.
         * @param errorOffset              the cause.  (A {@code null} value is permitted,
         *                           and indicates that the cause is nonexistent or unknown.)
         */
        public XMLParseException(String message, int errorOffset) {
            super(message,errorOffset);
        }
    }


