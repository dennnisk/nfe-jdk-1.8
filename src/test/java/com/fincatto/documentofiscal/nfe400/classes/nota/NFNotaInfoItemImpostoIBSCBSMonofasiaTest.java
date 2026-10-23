package com.fincatto.documentofiscal.nfe400.classes.nota;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NFNotaInfoItemImpostoIBSCBSMonofasiaTest {

    @Test
    public void deveGerarXmlAdRemComTodosOsGrupos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao padraoIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoPadrao();
        padraoIBS.setQBCMono(new BigDecimal("13"));
        padraoIBS.setAdRemIBS(new BigDecimal("1.1271"));
        padraoIBS.setVIBSMono(new BigDecimal("14.65"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten retenIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoReten();
        retenIBS.setQBCMonoReten(new BigDecimal("2"));
        retenIBS.setAdRemIBSReten(new BigDecimal("0.5"));
        retenIBS.setVIBSMonoReten(new BigDecimal("1"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet retIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGMonoRet();
        retIBS.setVIBSMonoRet(new BigDecimal("0.01"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca bioIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRemGpBioDiferenca();
        bioIBS.setQBCBioComb(new BigDecimal("0"));
        bioIBS.setVIBSDiferenca(new BigDecimal("0"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem adRemIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem();
        adRemIBS.setGpBioDiferenca(bioIBS);
        adRemIBS.setGMonoRet(retIBS);
        adRemIBS.setGMonoReten(retenIBS);
        adRemIBS.setGMonoPadrao(padraoIBS);

        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao padraoCBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRemGMonoPadrao();
        padraoCBS.setQBCMono(new BigDecimal("13"));
        padraoCBS.setAdRemCBS(new BigDecimal("0.4"));
        padraoCBS.setVCBSMono(new BigDecimal("5.2"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem adRemCBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem();
        adRemCBS.setGMonoPadrao(padraoCBS);

        final NFNotaInfoItemImpostoIBSCBSMonofasia mono = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        mono.setVTotCBSMonoItem(new BigDecimal("5.2"));
        mono.setVTotIBSMonoItem(new BigDecimal("15.65"));
        mono.setGCBSMonoAdRem(adRemCBS);
        mono.setGIBSMonoAdRem(adRemIBS);

        final String esperado = "<NFNotaInfoItemImpostoIBSCBSMonofasia>"
                + "<gIBSMonoAdRem>"
                + "<gMonoPadrao><qBCMono>13.0000</qBCMono><adRemIBS>1.1271</adRemIBS><vIBSMono>14.65</vIBSMono></gMonoPadrao>"
                + "<gMonoReten><qBCMonoReten>2.0000</qBCMonoReten><adRemIBSReten>0.50</adRemIBSReten><vIBSMonoReten>1.00</vIBSMonoReten></gMonoReten>"
                + "<gMonoRet><vIBSMonoRet>0.01</vIBSMonoRet></gMonoRet>"
                + "<gpBioDiferenca><qBCBioComb>0.0000</qBCBioComb><vIBSDiferenca>0.00</vIBSDiferenca></gpBioDiferenca>"
                + "</gIBSMonoAdRem>"
                + "<gCBSMonoAdRem>"
                + "<gMonoPadrao><qBCMono>13.0000</qBCMono><adRemCBS>0.40</adRemCBS><vCBSMono>5.20</vCBSMono></gMonoPadrao>"
                + "</gCBSMonoAdRem>"
                + "<vTotIBSMonoItem>15.65</vTotIBSMonoItem><vTotCBSMonoItem>5.20</vTotCBSMonoItem>"
                + "</NFNotaInfoItemImpostoIBSCBSMonofasia>";
        Assertions.assertEquals(esperado, mono.toString());
    }

    @Test
    public void deveGerarXmlAdValoremComRetencao() {
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten retenIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValoremGMonoReten();
        retenIBS.setVBCMonoReten(new BigDecimal("200"));
        retenIBS.setPAliqMonoReten(new BigDecimal("0.1"));
        retenIBS.setVIBSMonoReten(new BigDecimal("0.2"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem adValoremIBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem();
        adValoremIBS.setGMonoReten(retenIBS);

        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten retenCBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValoremGMonoReten();
        retenCBS.setVBCMonoReten(new BigDecimal("200"));
        retenCBS.setPAliqMonoReten(new BigDecimal("0.9"));
        retenCBS.setVCBSMonoReten(new BigDecimal("1.8"));
        final NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem adValoremCBS = new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem();
        adValoremCBS.setGMonoReten(retenCBS);

        final NFNotaInfoItemImpostoIBSCBSMonofasia mono = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        mono.setGIBSMonoAdValorem(adValoremIBS);
        mono.setGCBSMonoAdValorem(adValoremCBS);
        mono.setVTotIBSMonoItem(new BigDecimal("0.2"));
        mono.setVTotCBSMonoItem(new BigDecimal("1.8"));

        final String esperado = "<NFNotaInfoItemImpostoIBSCBSMonofasia>"
                + "<gIBSMonoAdValorem><gMonoReten><vBCMonoReten>200.00</vBCMonoReten><pAliqMonoReten>0.10</pAliqMonoReten><vIBSMonoReten>0.20</vIBSMonoReten></gMonoReten></gIBSMonoAdValorem>"
                + "<gCBSMonoAdValorem><gMonoReten><vBCMonoReten>200.00</vBCMonoReten><pAliqMonoReten>0.90</pAliqMonoReten><vCBSMonoReten>1.80</vCBSMonoReten></gMonoReten></gCBSMonoAdValorem>"
                + "<vTotIBSMonoItem>0.20</vTotIBSMonoItem><vTotCBSMonoItem>1.80</vTotCBSMonoItem>"
                + "</NFNotaInfoItemImpostoIBSCBSMonofasia>";
        Assertions.assertEquals(esperado, mono.toString());
    }

    @Test
    public void naoDevePermitirIbsAdRemEAdValoremJuntos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia mono = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        mono.setGIBSMonoAdRem(new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem());
        Assertions.assertThrows(IllegalStateException.class, () -> mono.setGIBSMonoAdValorem(new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdValorem()));
    }

    @Test
    public void naoDevePermitirCbsAdRemEAdValoremJuntos() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia mono = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        mono.setGCBSMonoAdValorem(new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdValorem());
        Assertions.assertThrows(IllegalStateException.class, () -> mono.setGCBSMonoAdRem(new NFNotaInfoItemImpostoIBSCBSMonofasicaGCBSMonoAdRem()));
    }

    @Test
    public void naoDevePermitirMonofasiaSemTotais() {
        final NFNotaInfoItemImpostoIBSCBSMonofasia mono = new NFNotaInfoItemImpostoIBSCBSMonofasia();
        mono.setGIBSMonoAdRem(new NFNotaInfoItemImpostoIBSCBSMonofasicaGIBSMonoAdRem());
        Assertions.assertThrows(IllegalStateException.class, mono::toString);
    }
}
