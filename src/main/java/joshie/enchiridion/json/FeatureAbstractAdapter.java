package joshie.enchiridion.json;

import com.google.gson.*;
import joshie.enchiridion.api.book.IFeature;
import joshie.enchiridion.data.book.FeatureProvider;
import joshie.enchiridion.helpers.JSONHelper;

import java.lang.reflect.Type;

public class FeatureAbstractAdapter implements JsonDeserializer<FeatureProvider> {
    @Override
    public FeatureProvider deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        FeatureProvider feature = new FeatureProvider();
        JsonObject jsonObject = json.getAsJsonObject();
        if (jsonObject.get("type") != null && jsonObject.get("type").getAsString() != null) { //OLD SYSTEM
            JsonObject properties = jsonObject.get("properties").getAsJsonObject();
            feature.xPos = properties.get("xPos").getAsInt();
            feature.yPos = properties.get("yPos").getAsInt();
            feature.width = properties.get("width").getAsInt();
            feature.height = properties.get("height").getAsInt();
            feature.feature = context.deserialize(jsonObject, IFeature.class);
        } else { //NEW System
            feature.xPos = jsonObject.get("xPos").getAsInt();
            feature.yPos = jsonObject.get("yPos").getAsInt();
            feature.width = jsonObject.get("width").getAsInt();
            feature.height = jsonObject.get("height").getAsInt();
            feature.isLocked = JSONHelper.getBooleanIfExists(jsonObject, "isLocked");
            feature.isHidden = JSONHelper.getBooleanIfExists(jsonObject, "isHidden");
            feature.feature = context.deserialize(jsonObject.get("feature"), IFeature.class);
        }

        return feature;
    }
}