package com.ForgeEssentials.util;

import com.ForgeEssentials.data.SaveableObject;
import com.ForgeEssentials.data.SaveableObject.Reconstructor;
import com.ForgeEssentials.data.SaveableObject.SaveableField;
import com.ForgeEssentials.data.SaveableObject.UniqueLoadingKey;
import com.ForgeEssentials.data.TaggedClass;
import com.ForgeEssentials.util.AreaSelector.WarpPoint;

@SaveableObject
public class Warp
{
	@UniqueLoadingKey
	@SaveableField
	private String name;

	@SaveableField
	private WarpPoint point;

	public Warp(String name, WarpPoint point)
	{
		this.name = name;
		this.point = point;
	}

	public String getName()
	{
		return name;
	}

	public WarpPoint getPoint()
	{
		return point;
	}

	@Reconstructor
	private static Warp reconstruct(TaggedClass tag)
	{
		return new Warp((String) tag.getFieldValue("name"), (WarpPoint) tag.getFieldValue("point"));
	}
}
