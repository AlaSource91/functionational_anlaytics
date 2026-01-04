public enum StatusPay
{
    PAID("paid"),
    UNPAID("unpaid");
    private final String value;

    StatusPay(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
