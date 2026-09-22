package org.geysermc.geyser.network;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.v1001.Bedrock_v1001;
import org.cloudburstmc.protocol.bedrock.codec.v2168.Bedrock_v2168;
import org.cloudburstmc.protocol.bedrock.codec.v2168.Bedrock_v2168_hotfix4;
import org.cloudburstmc.protocol.bedrock.codec.v2169.Bedrock_v2169;
import org.cloudburstmc.protocol.bedrock.codec.v2193.Bedrock_v2193; // НОВЫЙ ИМПОРТ
import org.cloudburstmc.protocol.bedrock.codec.v589.Bedrock_v589;
import org.cloudburstmc.protocol.bedrock.codec.v594.Bedrock_v594;
import org.cloudburstmc.protocol.bedrock.codec.v618.Bedrock_v618;
import org.cloudburstmc.protocol.bedrock.codec.v622.Bedrock_v622;
import org.cloudburstmc.protocol.bedrock.codec.v630.Bedrock_v630;
import org.cloudburstmc.protocol.bedrock.codec.v649.Bedrock_v649;
import org.cloudburstmc.protocol.bedrock.codec.v662.Bedrock_v662;
import org.cloudburstmc.protocol.bedrock.codec.v671.Bedrock_v671;
import org.cloudburstmc.protocol.bedrock.codec.v685.Bedrock_v685;
import org.cloudburstmc.protocol.bedrock.codec.v686.Bedrock_v686;
import org.cloudburstmc.protocol.bedrock.codec.v712.Bedrock_v712;
import org.cloudburstmc.protocol.bedrock.codec.v729.Bedrock_v729;
import org.cloudburstmc.protocol.bedrock.codec.v748.Bedrock_v748;
import org.cloudburstmc.protocol.bedrock.codec.v766.Bedrock_v766;
import org.cloudburstmc.protocol.bedrock.codec.v776.Bedrock_v776;
import org.cloudburstmc.protocol.bedrock.codec.v786.Bedrock_v786;
import org.cloudburstmc.protocol.bedrock.codec.v800.Bedrock_v800;
import org.cloudburstmc.protocol.bedrock.codec.v818.Bedrock_v818;
import org.cloudburstmc.protocol.bedrock.codec.v819.Bedrock_v819;
import org.cloudburstmc.protocol.bedrock.codec.v827.Bedrock_v827;
import org.cloudburstmc.protocol.bedrock.codec.v844.Bedrock_v844;
import org.cloudburstmc.protocol.bedrock.codec.v859.Bedrock_v859;
import org.cloudburstmc.protocol.bedrock.codec.v860.Bedrock_v860;
import org.cloudburstmc.protocol.bedrock.codec.v898.Bedrock_v898;
import org.cloudburstmc.protocol.bedrock.codec.v924.Bedrock_v924;
import org.cloudburstmc.protocol.bedrock.codec.v944.Bedrock_v944;
import org.cloudburstmc.protocol.bedrock.codec.v975.Bedrock_v975;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityFlag;
import org.cloudburstmc.protocol.bedrock.netty.codec.packet.BedrockPacketCodec;
import org.geysermc.geyser.api.util.MinecraftVersion;
import org.geysermc.geyser.impl.MinecraftVersionImpl;
import org.geysermc.mcprotocollib.protocol.codec.MinecraftCodec;
import org.geysermc.mcprotocollib.protocol.codec.PacketCodec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains information about the supported protocols in Geyser.
 */
public final class GameProtocol {

    static final List<BedrockCodec> SUPPORTED_BEDROCK_CODECS = new ArrayList<>();
    public static final IntList SUPPORTED_BEDROCK_PROTOCOLS = new IntArrayList();
    public static final List<MinecraftVersion> SUPPORTED_BEDROCK_VERSIONS = new ArrayList<>();
    public static final int DEFAULT_BEDROCK_PROTOCOL;
    public static final String DEFAULT_BEDROCK_VERSION;
    private static final PacketCodec DEFAULT_JAVA_CODEC = MinecraftCodec.CODEC;

    static {
        // Strict ordering
        register(Bedrock_v589.CODEC, "1.20.0", "1.20.1");
        register(Bedrock_v594.CODEC, "1.20.10", "1.20.15");
        register(Bedrock_v618.CODEC, "1.20.30", "1.20.32");
        register(Bedrock_v622.CODEC, "1.20.40", "1.20.41");
        register(Bedrock_v630.CODEC, "1.20.50", "1.20.51");
        register(Bedrock_v649.CODEC, "1.20.60", "1.20.61", "1.20.62");
        register(Bedrock_v662.CODEC, "1.20.70", "1.20.71", "1.20.72", "1.20.73");
        register(Bedrock_v671.CODEC, "1.20.80", "1.20.81");
        register(Bedrock_v685.CODEC, "1.21.0");
        register(Bedrock_v686.CODEC, "1.21.2");
        register(Bedrock_v712.CODEC, "1.21.20");
        register(Bedrock_v729.CODEC, "1.21.30");
        register(Bedrock_v748.CODEC, "1.21.40");
        register(Bedrock_v766.CODEC, "1.21.50");
        register(Bedrock_v776.CODEC, "1.21.60", "1.21.61", "1.21.62");
        register(Bedrock_v786.CODEC, "1.21.70");
        register(Bedrock_v800.CODEC, "1.21.80");
        register(Bedrock_v818.CODEC, "1.21.90", "1.21.91", "1.21.92");
        register(Bedrock_v819.CODEC, "1.21.93", "1.21.94");
        register(Bedrock_v827.CODEC, "1.21.100", "1.21.101");
        register(Bedrock_v844.CODEC, "1.21.111", "1.21.112", "1.21.113", "1.21.114");
        register(Bedrock_v859.CODEC, "1.21.120", "1.21.121", "1.21.122", "1.21.123");
        register(Bedrock_v860.CODEC, "1.21.124");
        register(Bedrock_v898.CODEC, "1.21.130", "1.21.131", "1.21.132");
        register(Bedrock_v924.CODEC, "26.0", "26.1", "26.2", "26.3");
        register(Bedrock_v944.CODEC, "26.10");
        register(Bedrock_v975.CODEC, "26.20", "26.21", "26.22", "26.23");
        register(Bedrock_v1001.CODEC, "26.30", "26.31", "26.32", "26.33", "26.34");
        register(Bedrock_v2168_hotfix4.CODEC, "26.40", "26.41", "26.42", "26.43", "26.44");
        register(Bedrock_v2169.CODEC, "26.45");

        // ДОБАВЛЕНО: 26.50 / 26.51, протокол 2193
        register(Bedrock_v2193.CODEC, "26.50", "26.51");

        MinecraftVersion latestBedrock = SUPPORTED_BEDROCK_VERSIONS.getLast();
        DEFAULT_BEDROCK_VERSION = latestBedrock.versionString();
        DEFAULT_BEDROCK_PROTOCOL = latestBedrock.protocolVersion();
    }

    private static void register(BedrockCodec codec, String... minecraftVersions) {
        codec = CodecProcessor.processCodec(codec);

        SUPPORTED_BEDROCK_CODECS.add(codec);
        SUPPORTED_BEDROCK_PROTOCOLS.add(codec.getProtocolVersion());

        for (String version : minecraftVersions) {
            SUPPORTED_BEDROCK_VERSIONS.add(new MinecraftVersionImpl(version, codec.getProtocolVersion()));
        }
    }

    private static void register(BedrockCodec codec) {
        register(codec, codec.getMinecraftVersion());
    }

    public static @Nullable BedrockCodec getBedrockCodec(int protocolVersion) {
        for (BedrockCodec packetCodec : SUPPORTED_BEDROCK_CODECS) {
            if (packetCodec.getProtocolVersion() == protocolVersion) {
                return packetCodec;
            }
        }
        return null;
    }

    /* Bedrock convenience methods */
    public static boolean is1_20_0orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v589.CODEC.getProtocolVersion();
    }

    public static boolean is1_20_70orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v662.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_0orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v685.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_50orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v766.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_70orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v786.CODEC.getProtocolVersion();
    }

    public static boolean isPreCreativeInventoryRewrite(int protocolVersion) {
        return protocolVersion < Bedrock_v776.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_80orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v800.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_80(int protocolVersion) {
        return protocolVersion == Bedrock_v800.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_90orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v818.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_110orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v844.CODEC.getProtocolVersion();
    }

    public static boolean is1_21_130orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v898.CODEC.getProtocolVersion();
    }

    public static boolean is26_0orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v924.CODEC.getProtocolVersion();
    }

    public static boolean is26_10orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v944.CODEC.getProtocolVersion();
    }

    public static boolean is26_20orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v975.CODEC.getProtocolVersion();
    }

    public static boolean is26_30orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v1001.CODEC.getProtocolVersion();
    }

    public static boolean is26_40orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v2168.CODEC.getProtocolVersion();
    }

    public static boolean is26_45orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v2169.CODEC.getProtocolVersion();
    }

    // ДОБАВЛЕНО: 26.50 / 26.51
    public static boolean is26_50orHigher(int protocolVersion) {
        return protocolVersion >= Bedrock_v2193.CODEC.getProtocolVersion();
    }

    public static boolean isEntityFlagSupported(EntityFlag flag, int protocolVersion) {
        return switch (flag) {
            case CRAWLING -> protocolVersion >= Bedrock_v594.CODEC.getProtocolVersion();
            case TIMER_FLAG_1, TIMER_FLAG_2, TIMER_FLAG_3 -> protocolVersion >= Bedrock_v622.CODEC.getProtocolVersion();
            case BODY_ROTATION_BLOCKED -> protocolVersion >= Bedrock_v671.CODEC.getProtocolVersion();
            case RENDER_WHEN_INVISIBLE -> protocolVersion >= Bedrock_v776.CODEC.getProtocolVersion();
            case BODY_ROTATION_AXIS_ALIGNED, COLLIDABLE, WASD_AIR_CONTROLLED ->
                protocolVersion >= Bedrock_v786.CODEC.getProtocolVersion();
            case DOES_SERVER_AUTH_ONLY_DISMOUNT -> protocolVersion >= Bedrock_v800.CODEC.getProtocolVersion();
            case BODY_ROTATION_ALWAYS_FOLLOWS_HEAD -> protocolVersion >= Bedrock_v818.CODEC.getProtocolVersion();
            case CAN_USE_VERTICAL_MOVEMENT_ACTION -> protocolVersion >= Bedrock_v844.CODEC.getProtocolVersion();
            case BODY_ROTATION_LOCKED_TO_VEHICLE -> protocolVersion >= Bedrock_v859.CODEC.getProtocolVersion();
            case USES_LEGACY_FRICTION, USES_UNIFORM_AIR_DRAG, NAMEPLATE_DEPTH_TESTED ->
                protocolVersion >= Bedrock_v975.CODEC.getProtocolVersion();
            default -> true;
        };
    }

    public static List<String> getJavaVersions() {
        return List.of(DEFAULT_JAVA_CODEC.getMinecraftVersion(), "26.1.1", "26.1.2");
    }

    public static int getJavaProtocolVersion() {
        return DEFAULT_JAVA_CODEC.getProtocolVersion();
    }

    public static String getJavaMinecraftVersion() {
        return DEFAULT_JAVA_CODEC.getMinecraftVersion();
    }

    public static String getAllSupportedBedrockVersions() {
        return SUPPORTED_BEDROCK_VERSIONS.stream()
            .map(MinecraftVersion::versionString)
            .collect(Collectors.joining(", "));
    }

    public static String getAllSupportedJavaVersions() {
        return String.join(", ", getJavaVersions());
    }

    private GameProtocol() {
    }
}