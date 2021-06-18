package repository;


import entities.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OptionsRepository extends JpaRepository<Options, Integer> {

    @Modifying
    @Query("update Options o set o.conditioner = :conditioner, o.leather = :leather, o.alloyWheels = :alloy_wheels, " +
            "o.xenon = :xenon, o.pdc = :pdc, o.assHeating = :ass_heating, o.ascSystem = :asc_system, o.navi = :navi," +
            "o.speakerphone = :speakerphone,  o.fogLights = :fog_lights, o.signaling = :signaling where o.id = :id")
    void updateOptionsById(@Param("id") Integer id, @Param("conditioner") Boolean conditioner,
                           @Param("leather") Boolean leather, @Param("alloy_wheels") Boolean alloy_wheels,
                           @Param("xenon") Boolean xenon, @Param("pdc") Boolean pdc,
                           @Param("ass_heating") Boolean ass_heating, @Param("asc_system") Boolean asc_system,
                           @Param("navi") Boolean navi, @Param("speakerphone") Boolean speakerphone,
                           @Param("fog_lights") Boolean fog_lights, @Param("signaling") Boolean signaling);
}
