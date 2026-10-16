package itv1.sbw.cp.entity.vehicle;

import com.atsuishio.superbwarfare.config.server.VehicleConfig;
import com.atsuishio.superbwarfare.entity.vehicle.base.VehicleEntity;
import com.atsuishio.superbwarfare.entity.vehicle.utils.VehicleVecUtils;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.MoveFunction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import org.joml.Matrix4d;
import org.joml.Vector4d;
import org.slf4j.Logger;

public class Vaz2107Entity extends VehicleEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    public Vaz2107Entity(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (decoyInputDown()) {
            horn();
        }
    }

    /**
     * SBW 0.8.9.2 теряет X/Z мест при посадке (всех сажает в центр, проверено и на
     * ванильном БМП-2). Раскладываем пассажиров по местам сами тем же rigid-транcформом,
     * что использует высадка (она работает). Оффсеты дублируют JSON (источник правды там).
     */
    private static final double[][] SEAT_OFFSETS = {
            {0.5, -0.1, 0.1},
            {-0.5, -0.1, 0.1},
            {0.5, -0.1, -0.9},
            {-0.5, -0.1, -0.9}
    };

    @Override
    public void positionRider(Entity passenger, MoveFunction callback) {
        int index = getSeatIndex(passenger);
        if (index < 0 || index >= SEAT_OFFSETS.length) {
            index = 0;
        }
        double[] o = SEAT_OFFSETS[index];
        Matrix4d transform = getTransformFromString("Vehicle", 1f);
        Vector4d world = VehicleVecUtils.transformPosition(transform, o[0], o[1], o[2]);
        double yOffset = VehicleConfig.getPassengerYOffset(passenger.getType());
        passenger.setPos(world.x, world.y + yOffset, world.z);
        callback.accept(passenger, world.x, world.y + yOffset, world.z);
        copyEntityData(passenger);
    }
}
