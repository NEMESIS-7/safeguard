# Reconciliation product: research notes

Date: 25 November 2026. Desk research only: web searches and public pages. No customer interviews.

## Verdict

- **Not an empty market.** Reconciliation products exist globally, in Africa, and in small forms in Ghana.
- **Possible gap (hypothesis):** matching statements from several channels (MTN MoMo, Telecel Cash, banks, aggregators) against expected payments, with an exceptions workflow, priced and set up for a mid-sized Ghanaian organisation.
- **No defensible advantage today.** One could be earned through statement parsers tested on real files, matching rules for how people here actually write references, and workflows users depend on. All three need real users.

## What exists

| Product | What was seen | Limit seen | Checked |
|---|---|---|---|
| [Credrails](https://credrails.com/) | Reconciliation SaaS: duplicates, missing items, reversals, public API docs; appears live | Ghana not mentioned; amounts shown in NGN; no public pricing | Page read |
| [Reconrails](https://reconrails.com/) | Aimed at African banks; M-Pesa, Airtel Money, core banking | Page failed to load | Search summary only |
| [CliqPOS](https://cliqpos.com/mobile-money-pos-ghana) | Ghana POS with MoMo, from GHS 199/month | Reconciles what cashiers type; no matching engine described | Page read |
| [momo-agentic-hub](https://github.com/gadzorgenu/momo-agentic-hub) | Matches SMS receipts to orders for Ghana SMEs (MTN, Telecel, AT) | Looks like a prototype | Page read |
| [ERPNext](https://www.powersoftsystem.com/post/mobile-money-reconciliation-in-erpnext) | Bank reconciliation tool used for MoMo accounts | Needs an ERP; article body not read | Search summary only |
| [MomoSense](https://www.momosense.app/) | Turns MTN SMS alerts into records | MTN only at time of search | Search summary only |
| [BizTrack Pro](https://biztrackpro.app/) | Small business app with MoMo reconciliation | Depth unknown | Search summary only |
| Paystack | Exports and settlement reports for its own merchants | Own channel; docs returned 403 | Search summary only |
| Global tools ([example list](https://rexi.finance/blog/payment-reconciliation-software/reconciliation-software-for-fintech-teams.html)) | Enterprise and API-first matching | Ghana fit unknown | Search summary only |

## Data we can build with

- **MTN MoMo statements:** PDF download from app or portal, usually up to 12 months, according to an [editorial guide](https://accrastreetjournal.com/2025/12/11/how-to-print-your-mtn-momo-statement-online/). Exact columns unknown until a real file is inspected.
- **MTN partner portal:** three months of transactions for collection partners ([MTN developer portal](https://momodeveloper.mtn.com/Ghana_Collection_productDetails)). The same page lists a 2% collection fee, negotiable. Sandbox availability for Ghana collections not confirmed.
- **Paystack, banks, Telecel:** formats not yet seen.
- **Synthetic data:** a generator that creates expected payments and statements with injected faults (missing, duplicate, partial, wrong reference, reversal, fee deducted, late settlement). Because the correct answers are known, matching accuracy can be measured.
- **Own statement:** a personal MoMo statement gives a real layout. Keep it out of git and anonymise any sample.

## Unknowns to close

1. Which segment hurts most, and what do they use now?
2. Competitors for that segment (school fee systems in Ghana were not searched).
3. Real column layouts for each channel.
4. Data protection obligations (Ghana's Data Protection Act, 2012) and whether any Bank of Ghana licence applies to a read-only tool.
5. Whether Credrails or Reconrails sell in Ghana.

## Segment chosen: tertiary institutions

This replaces schools, and unknown 2 above now means university fee systems.

### Evidence

| Finding | Source |
|---|---|
| University of Ghana lists many approved banks, UGPay (card and mobile money) and several bank USSD codes. Students must quote index number and name, use a deposit slip at banks, and take payment problems to the Students Accounts Office | [UG payment information](https://www.ug.edu.gh/aad/sites/academic.ug.edu.gh/files/2024-09/PAYMENT%20INFO%20-%20REGULAR.pdf), 2024 file, text extracted |
| University of Education, Winneba collects through Transflow, which its policy says credits the student portal. Students still submit the receipt to a faculty accountant for verification, and get a clearance form within two working days | [UEW fee policy 2024/2025](https://uew.edu.gh/sites/default/files/2024-11/fee_payment_policy-2024-2025_academic_year_1.pdf), text extracted |
| Auditor-General reports on technical universities repeatedly raise uncollected fees; a 2018 finding cited fees outstanding in a bank account | [audit.gov.gh](https://audit.gov.gh/files/audit_reports/Report_of_the_Auditor-General_on_the_public_accounts_of_Ghana_-_Technical_Universities_and_Colleges_of_Education_for_the_year_ended_31_December_2023.pdf), search snippets only |

### Position (hypothesis)

Not another way to pay. A layer behind banks, Transflow and online gateways: import each channel's records, match them to student bills, work the exceptions, issue financial clearance automatically, and show students where their payment stands.

### Risks

- Transflow, bank platforms and in-house systems already post payments. How often posting fails is unknown.
- Public universities are likely to buy slowly, through formal procurement.
- Real bank and gateway files will be hard to get.
- Student data raises data protection duties.

### Questions for students, course representatives and accounts staff

1. When did a payment last fail to show, and how long did the fix take?
2. Which channel was used?
3. Who did the student have to visit, and with what proof?
4. How many cases arrive in registration week?
5. How does the accounts office match bank records today?

## Other gaps looked at

| Area | Signal | Concern |
|---|---|---|
| E-VAT invoicing | Reported mandatory for VAT-registered businesses from January 2026 ([Fonoa](https://www.fonoa.com/resources/blog/ghana-e-vat-e-invoicing-2026)) | Several vendors already market solutions |
| Small business accounting and receivables | Weakness reported in secondary commentary | Crowded, low willingness to pay likely |
| Microfinance transition | Bank of Ghana deadline 31 December 2026 | Too close to build for the transition itself |

## Draft boundaries

**In:** statement import, normalisation, expected payments, matching, exceptions queue, reversals, double-entry ledger, audit trail, multi-organisation access control.

**Out for version 1:** moving or holding money, live provider APIs, lending, mobile app, machine-learning matching.
