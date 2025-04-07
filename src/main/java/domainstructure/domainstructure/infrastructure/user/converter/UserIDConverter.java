package domainstructure.domainstructure.infrastructure.user.converter;

import domainstructure.domainstructure.core.user.vo.UserID;
import jakarta.persistence.AttributeConverter;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UserIDConverter implements AttributeConverter<UserID, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(UserID attribute) {
        if (attribute == null) return null;
        UUID uuid = UUID.fromString(attribute.getValue());
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    @Override
    public UserID convertToEntityAttribute(byte[] dbData) {
        if (dbData == null || dbData.length != 16) return null;
        ByteBuffer bb = ByteBuffer.wrap(dbData);
        long high = bb.getLong();
        long low = bb.getLong();
        UUID uuid = new UUID(high, low);
        return UserID.of(uuid.toString());
    }
}
