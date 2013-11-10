package org.zzl.minegaming.GBAUtils;

public class BitConverter
{
	protected BitConverter(){}
	
	public static long ToInt32(byte[] bytez)
	{
		//AB CD EF 08 -> 08EFCDAB
		int[] bytes = ToInts(bytez);
		long l = (long)(bytes[0] + (bytes[1] << 8) + (bytes[2] << 16) + (bytes[3] << 24));
		return l;
	}
	
	public static int shortenPointer(long pointer)
	{
		return (int)(pointer & 0xFFFFFF);
	}
	
	public static byte[] GetBytes(long i)
	{
		return new byte[] { (byte)(i & 0xFF000000 >> 24), (byte)(i & 0x00FF0000 >> 16), (byte)(i & 0x0000FF00 >> 8), (byte)(i & 0x000000FF) };
	}

	public static byte[] GrabBytes(byte[] array, int offset, int length)
	{
		byte[] result = new byte[length];
		for(int i = 0; i < length; i++)
		{
			result[i] = array[offset+i];
		}
		return result;
	}
	
	public static int[] GrabBytesAsInts(byte[] array, int offset, int length)
	{
		if(length > array.length)
			length = array.length;
		int[] result = new int[length];
		for(int i = 0; i < length; i++)
		{
			result[i] = (array[offset+i] & 0xFF);
		}
		return result;
	}

	public static int[] ToInts(byte[] array)
	{
		return GrabBytesAsInts(array,0,array.length);
	}

	public static String toHexString(int b)
	{
		return toHexString(b,false);
	}
	
	public static String toHexString(int b, boolean spacing)
	{
		if(spacing)
			return String.format("%02X", Math.abs(b)); //Use absolute value to prevent negative bytes
		else
			return String.format("%X", Math.abs(b));
	}
	
	public static String toDwordString(int b, boolean spacing)
	{
		if(spacing)
			return String.format("%06X", Math.abs(b)); //Use absolute value to prevent negative bytes
		else
			return String.format("%X", Math.abs(b));
	}
	
	public static String byteToStringNoZero(int b)
	{
		if(b != 0)
			return String.format("%X", Math.abs(b));
		else
			return "";
	}

	
	public static byte[] toBytes(int[] data)
	{
		byte[] result = new byte[data.length];
		for(int i = 0; i < result.length; i++)
		{
			result[i] = (byte)(data[i]);
		}
		return result;
	}
}
