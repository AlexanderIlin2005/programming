package exceptions;

import enums.Product;

public class cannotSetPriceException extends Exception
{
    public cannotSetPriceException(String message)
    {
        super(message);
    }
}
