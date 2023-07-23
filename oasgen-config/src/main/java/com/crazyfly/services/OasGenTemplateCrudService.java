package com.crazyfly.services;

import com.crazyfly.models.OasGenTemplate;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class OasGenTemplateCrudService {

    private static final Logger LOG = Logger.getLogger(OasGenTemplateCrudService.class);


    @Channel("oasgen-templates-events")
    Emitter<OasGenTemplate> emitter;

    @Inject
    Mutiny.SessionFactory sf;

    public Uni<List<OasGenTemplate>> getOasGenTemplates() {
        CriteriaQuery<OasGenTemplate> query = sf.getCriteriaBuilder().createQuery(OasGenTemplate.class);
        Root<OasGenTemplate> a = query.from(OasGenTemplate.class);
        query.select(a);
        return sf.withSession(session -> session.createQuery(query).getResultList());
    }

    public Uni<OasGenTemplate> getOasGenTemplate(int id) {
        return sf.withSession(session -> session.find(OasGenTemplate.class,id));
    }

    public Uni<Void> createOasGenTemplate(@Valid OasGenTemplate oasGenTemplate) {
        return sf.withSession(session -> session.persist(oasGenTemplate));
//                .replaceWith(oasGenTemplate)
//                .onItem()
//                .invoke( oasGenTemplate1 -> emitter.send(oasGenTemplate1));
    }

    public Uni<OasGenTemplate> updateOasGenTemplate(int id, @Valid OasGenTemplate oasGenTemplate){
        return sf.withSession(session -> session.find(OasGenTemplate.class,id).call(session::refresh))
                .onItem()
                .invoke(oasGenTemplate1 -> emitter.send(oasGenTemplate1));
    }

    public Uni<OasGenTemplate> deleteOasGenTemplate(@PathParam("id") int id) {
        return sf.withSession(session -> session.find(OasGenTemplate.class,id).call(session::remove))
                .onItem()
                .invoke(oasGenTemplate1 -> emitter.send(oasGenTemplate1));
    }

}
