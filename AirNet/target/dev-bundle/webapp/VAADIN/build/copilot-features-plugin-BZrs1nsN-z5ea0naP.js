import { U as Ut, t as tn, m as mt, a as bs } from "./indexhtml-B9JsqKOD.js";
import { g } from "./state-u4Ab_TUl-0i0Tx-fP.js";
import { o } from "./base-panel-DqpMqJVg-hj3q_eaE.js";
import { showNotification as N } from "./copilot-notification-CLx3j4dp-4jB6O8xW.js";
import { r as r$1 } from "./icons-BIim_4GH-CG3WWzIP.js";
const b = "copilot-features-panel{padding:var(--space-100);font:var(--font-xsmall);display:grid;grid-template-columns:auto 1fr;gap:var(--space-50);height:auto}copilot-features-panel a{display:flex;align-items:center;gap:var(--space-50);white-space:nowrap}copilot-features-panel a svg{height:12px;width:12px;min-height:12px;min-width:12px}";
var F = Object.defineProperty, w = Object.getOwnPropertyDescriptor, d = (e, t, a, o2) => {
  for (var s = o2 > 1 ? void 0 : o2 ? w(t, a) : t, r = e.length - 1, l; r >= 0; r--)
    (l = e[r]) && (s = (o2 ? l(t, a, s) : l(s)) || s);
  return o2 && s && F(t, a, s), s;
};
const n = window.Vaadin.devTools;
let i = class extends o {
  constructor() {
    super(...arguments), this.features = [], this.handleFeatureFlags = (e) => {
      this.features = e.data.features;
    };
  }
  connectedCallback() {
    super.connectedCallback(), this.onCommand("featureFlags", this.handleFeatureFlags);
  }
  render() {
    return Ut` <style>
        ${b}
      </style>
      ${this.features.map(
      (e) => Ut`
          <copilot-toggle-button
            .title="${e.title}"
            ?checked=${e.enabled}
            @on-change=${(t) => this.toggleFeatureFlag(t, e)}>
          </copilot-toggle-button>
          <a class="ahreflike" href="${e.moreInfoLink}" title="Learn more" target="_blank"
            >learn more ${r$1.linkExternal}</a
          >
        `
    )}`;
  }
  toggleFeatureFlag(e, t) {
    const a = e.target.checked;
    tn("use-feature", { source: "toggle", enabled: a, id: t.id }), n.frontendConnection ? (n.frontendConnection.send("setFeature", { featureId: t.id, enabled: a }), N({
      type: mt.INFORMATION,
      message: `“${t.title}” ${a ? "enabled" : "disabled"}`,
      details: t.requiresServerRestart ? "This feature requires a server restart" : void 0,
      dismissId: `feature${t.id}${a ? "Enabled" : "Disabled"}`
    })) : n.log("error", `Unable to toggle feature ${t.title}: No server connection available`);
  }
};
d([
  g()
], i.prototype, "features", 2);
i = d([
  bs("copilot-features-panel")
], i);
const $ = {
  header: "Features",
  expanded: false,
  panelOrder: 35,
  panel: "right",
  floating: false,
  tag: "copilot-features-panel",
  helpUrl: "https://vaadin.com/docs/latest/flow/configuration/feature-flags"
}, x = {
  init(e) {
    e.addPanel($);
  }
};
window.Vaadin.copilot.plugins.push(x);
export {
  i as CopilotFeaturesPanel
};
